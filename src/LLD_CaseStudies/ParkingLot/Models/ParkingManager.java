package LLD_CaseStudies.ParkingLot.Models;

import LLD_CaseStudies.ParkingLot.Enums.SpotStatus;
import LLD_CaseStudies.ParkingLot.Enums.SpotType;
import LLD_CaseStudies.ParkingLot.Enums.TicketStatus;
import LLD_CaseStudies.ParkingLot.Enums.VehicleType;

import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.*;

import static LLD_CaseStudies.ParkingLot.Enums.SpotStatus.RESERVED;

public class ParkingManager {
    private String id;
    private Map<String, ParkingSpot> spotMap = new ConcurrentHashMap<>();
    private Map<String, ParkingTicket> ticketMap = new ConcurrentHashMap<>();
    private Map<SpotType, ConcurrentLinkedQueue<ParkingSpot>> availableByType = new EnumMap<>(SpotType.class);
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final PricingStrategy pricingStrategy;
    private final long reservationTimeoutSeconds = 540;

    public ParkingManager(String id, PricingStrategy pricingStrategy) {
        this.id = id;
        this.pricingStrategy = pricingStrategy;
        for (SpotType st : SpotType.values()) availableByType.put(st, new ConcurrentLinkedQueue<>());

    }

    // Build lot: adding spots
    void addSpot(ParkingSpot spot) {
        spotMap.put(spot.getId(), spot);
        availableByType.get(spot.getSpotType()).add(spot);
    }

    // Find candidate spot type for vehicle - simple mapping
    private SpotType mapVehicleToSpotType(VehicleType vt) {
        switch (vt) {
            case MOTORCYCLE: return SpotType.MOTORCYCLE;
            case CAR: return SpotType.COMPACT;
            case TRUCK: return SpotType.LARGE;
            case EV: return SpotType.EV;
            default: return SpotType.COMPACT;
        }
    }

    private void handleReservationTimeout(String ticketId) {
        ParkingTicket t = ticketMap.get(ticketId);
        if (t != null && t.status == TicketStatus.PENDING) {
            // release spot
            ParkingSpot s = spotMap.get(t.getSpotId());
            if (s != null && s.lock.tryLock()) {
                try {
                    if (s.getSpotStatus() == SpotStatus.RESERVED) {
                        s.setSpotStatus(SpotStatus.AVAILABLE);
                        availableByType.get(s.getSpotType()).add(s);
                        ticketMap.remove(ticketId);
                    }
                } finally {
                    s.lock.unlock();
                }
            }
        }
    }



    // Simulate payment success to confirm ticket -> activate
    public boolean confirmPayment(String ticketId) {
        ParkingTicket t = ticketMap.get(ticketId);
        if (t == null) return false;
        ParkingSpot s = spotMap.get(t.getSpotId());
        if (s == null) return false;
        // lock to transition
        s.lock.lock();
        try {
            if (s.getSpotStatus() != SpotStatus.RESERVED) return false;
            s.setSpotStatus(SpotStatus.OCCUPIED);
            t.status = TicketStatus.ACTIVE;
            return true;
        } finally {
            s.lock.unlock();
        }
    }


    // Park vehicle: returns ticket or null if no spot
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        SpotType desired = mapVehicleToSpotType(vehicle.getVehicleType());
        ParkingSpot spot = allocateSpot(desired);
        if (spot == null) return null; // no spot
        String ticketId = UUID.randomUUID().toString();
        ParkingTicket ticket = new ParkingTicket(ticketId, spot.id, vehicle);
        ticketMap.put(ticketId, ticket);
        // schedule reservation timeout
        scheduler.schedule(() -> handleReservationTimeout(ticketId), reservationTimeoutSeconds, TimeUnit.SECONDS);
        return ticket;
    }

    // Unpark vehicle: compute fee, free spot
    public double unpark(String ticketId) {
        ParkingTicket t = ticketMap.get(ticketId);
        if (t == null) throw new RuntimeException("Invalid ticket");
        ParkingSpot s = spotMap.get(t.getSpotId());
        if (s == null) throw new RuntimeException("Invalid spot");

        s.lock.lock();
        try {
            if (s.getSpotStatus() != SpotStatus.OCCUPIED) throw new RuntimeException("Spot not occupied");
            t.outTime = Instant.now();
            double amount = pricingStrategy.calculate(t);
            t.amount = amount;
            t.status = TicketStatus.CLOSED;
            // free spot
            s.setSpotStatus(SpotStatus.AVAILABLE);
            availableByType.get(s.getSpotType()).add(s);
            // keep ticket record for history; optionally remove
            return amount;
        } finally {
            s.lock.unlock();
        }
    }


    // Try allocate spot of given type (simple algorithm)
    private ParkingSpot allocateSpot(SpotType type) {
        Queue<ParkingSpot> queue = availableByType.get(type);
        if (queue == null) return null;
        for (int i = 0; i < queue.size(); i++) {
            ParkingSpot spot = queue.poll();
            if (spot == null) break;
            boolean locked = spot.lock.tryLock();
            if (!locked) {
                // someone racing; put back and continue
                queue.add(spot);
                continue;
            }
            try {
                if (spot.getSpotStatus() == SpotStatus.AVAILABLE) {
                    spot.setSpotStatus(RESERVED);
                    // Note: reserve but do not remove entirely from map—it's held by ticket
                    return spot;
                } else {
                    // shouldn't happen, but put back
                    queue.add(spot);
                }
            } finally {
                spot.lock.unlock();
            }
        }
        return null;
    }

    // Query available count
    public int getAvailableCount(SpotType type) {
        return availableByType.get(type).size();
    }







}
