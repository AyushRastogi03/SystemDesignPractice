package LLD_CaseStudies.ParkingLotNew.Service;

import LLD_CaseStudies.ParkingLotNew.Enums.PaymentMethod;
import LLD_CaseStudies.ParkingLotNew.Enums.PaymentStatus;
import LLD_CaseStudies.ParkingLotNew.Enums.GateType;
import LLD_CaseStudies.ParkingLotNew.Enums.SpotState;
import LLD_CaseStudies.ParkingLotNew.Enums.SpotType;
import LLD_CaseStudies.ParkingLotNew.Enums.TicketStatus;
import LLD_CaseStudies.ParkingLotNew.Enums.VehicleType;
import LLD_CaseStudies.ParkingLotNew.Models.Floor;
import LLD_CaseStudies.ParkingLotNew.Models.Gate;
import LLD_CaseStudies.ParkingLotNew.Models.ParkingLot;
import LLD_CaseStudies.ParkingLotNew.Models.ParkingSpot;
import LLD_CaseStudies.ParkingLotNew.Models.Payment;
import LLD_CaseStudies.ParkingLotNew.Models.Ticket;
import LLD_CaseStudies.ParkingLotNew.Models.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingManagerService {
    private static final double HOURLY_RATE = 20.0;

    private final ParkingLot parkingLot;
    // The parking lot is shared by all entry/exit threads.
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    public ParkingManagerService(ParkingLot parkingLot) {
        if (parkingLot == null) {
            throw new IllegalArgumentException("Parking lot cannot be null");
        }
        this.parkingLot = parkingLot;
    }

    /** Convenience constructor for the demo application. */
    public ParkingManagerService() {
        this(new ParkingLot());
    }


    public Ticket parkVehicle(Vehicle vehicle, Gate entryGate){
        validateVehicle(vehicle);
        validateEntryGate(entryGate);

        ParkingSpot spot = claimAvailableSpot(vehicle.getVehicleType());
        if (spot == null) {
            throw new IllegalStateException("No compatible parking spot is available");
        }

        Ticket ticket = new Ticket();
        try {
            ticket.setTicketNumber(UUID.randomUUID().toString());
            ticket.setTicketStatus(TicketStatus.ACTIVE);
            ticket.setVehicle(vehicle);
            ticket.setParkingSpot(spot);
            ticket.setEntryGate(entryGate);
            ticket.setEntryTime(LocalDateTime.now());

            activeTickets.put(ticket.getTicketNumber(), ticket);
            return ticket;
        } catch (RuntimeException exception) {
            // Do not leak an occupied spot if ticket creation/registration fails.
            spot.release();
            throw exception;
        }
    }

    public Double calculateAmount(String ticketNumber){
        Ticket ticket = getActiveTicket(ticketNumber);
        long elapsedMinutes = Math.max(
                1,
                Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes()
        );
        long chargedHours = (long) Math.ceil(elapsedMinutes / 60.0);
        return chargedHours * HOURLY_RATE;
    }

    public PaymentStatus makePaymentAndReleaseSpot(
            String ticketNumber,
            PaymentMethod paymentMethod,
            double amount
    ) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }

        Ticket ticket = getActiveTicket(ticketNumber);
        ticket.getLifecycleLock().lock();
        try {
            // Re-check after acquiring the ticket lock. Another exit request may
            // have completed while this request was waiting.
            if (activeTickets.get(ticketNumber) != ticket
                    || ticket.getTicketStatus() != TicketStatus.ACTIVE) {
                throw new IllegalStateException("Ticket is already closed");
            }

            double calculatedAmount = calculateAmount(ticketNumber);
            if (Double.compare(amount, calculatedAmount) != 0) {
                throw new IllegalArgumentException(
                        "Incorrect payment amount. Expected: " + calculatedAmount
                );
            }

            // Payment is simulated here. A real implementation would call a
            // gateway and release the spot only after verified success/webhook.
            Payment payment = new Payment();
            payment.setPaymentId(UUID.randomUUID().toString());
            payment.setPaymentAmount(calculatedAmount);
            payment.setPaymentStatus(PaymentStatus.PAID);

            ticket.setPayment(payment);
            ticket.setExitTime(LocalDateTime.now());
            ticket.setTicketStatus(TicketStatus.CLOSED);
            ticket.getParkingSpot().release();
            activeTickets.remove(ticketNumber, ticket);

            return payment.getPaymentStatus();
        } finally {
            ticket.getLifecycleLock().unlock();
        }
    }

    /** Claims the spot while holding the spot's lock; never returns an unclaimed spot. */
    private ParkingSpot claimAvailableSpot(VehicleType vehicleType) {
        SpotType requiredType = requiredSpotType(vehicleType);
        if (parkingLot.getParkingFloors() == null) {
            return null;
        }
        for (Floor floor : parkingLot.getParkingFloors()) {
            if (floor.getParkingSpotList() == null) {
                continue;
            }
            for (ParkingSpot spot : floor.getParkingSpotList()) {
                if (spot.getSpotType() == requiredType && spot.tryOccupy()) {
                    return spot;
                }
            }
        }
        return null;
    }

    private SpotType requiredSpotType(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return SpotType.BIKE;
            case CAR:
                return SpotType.COMPACT;
            case TRUCK:
                return SpotType.LARGE;
            case EV:
                return SpotType.EV;
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }

    private Ticket getActiveTicket(String ticketNumber) {
        if (ticketNumber == null || !activeTickets.containsKey(ticketNumber)) {
            throw new IllegalArgumentException("Invalid or closed ticket");
        }
        return activeTickets.get(ticketNumber);
    }

    private void validateVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicle.getVehicleNumber() == null
                || vehicle.getVehicleType() == null) {
            throw new IllegalArgumentException("Vehicle and its details are required");
        }
    }

    private void validateEntryGate(Gate entryGate) {
        if (entryGate == null
                || entryGate.getGateType() == null
                || entryGate.getGateType() != GateType.ENTRY_GATE) {
            throw new IllegalArgumentException("A valid entry gate is required");
        }
    }
}
