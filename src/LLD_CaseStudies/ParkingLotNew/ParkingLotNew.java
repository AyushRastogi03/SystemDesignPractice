package LLD_CaseStudies.ParkingLotNew;

import LLD_CaseStudies.ParkingLotNew.Enums.GateType;
import LLD_CaseStudies.ParkingLotNew.Enums.PaymentMethod;
import LLD_CaseStudies.ParkingLotNew.Enums.VehicleType;
import LLD_CaseStudies.ParkingLotNew.Models.Floor;
import LLD_CaseStudies.ParkingLotNew.Models.Gate;
import LLD_CaseStudies.ParkingLotNew.Models.ParkingLot;
import LLD_CaseStudies.ParkingLotNew.Models.ParkingSpot;
import LLD_CaseStudies.ParkingLotNew.Models.Ticket;
import LLD_CaseStudies.ParkingLotNew.Models.Vehicle;
import LLD_CaseStudies.ParkingLotNew.Service.ParkingManagerService;
import LLD_CaseStudies.ParkingLotNew.Enums.SpotState;
import LLD_CaseStudies.ParkingLotNew.Enums.SpotType;

import java.util.Arrays;

public class ParkingLotNew {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Floor floor = new Floor();
        floor.setFloorId("F1");
        floor.setParkingSpotList(Arrays.asList(
                createSpot("S1", SpotType.COMPACT),
                createSpot("S2", SpotType.BIKE),
                createSpot("S3", SpotType.EV)
        ));
        parkingLot.setParkingFloors(Arrays.asList(floor));

        ParkingManagerService parkingManagerService = new ParkingManagerService(parkingLot);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("KA-01-1234");
        vehicle.setVehicleType(VehicleType.CAR);

        Gate entryGate = new Gate();
        entryGate.setGateType(GateType.ENTRY_GATE);
        entryGate.setGateId("Gate1");


        Ticket ticket = parkingManagerService.parkVehicle(vehicle, entryGate);
        double amount = parkingManagerService.calculateAmount(ticket.getTicketNumber());
        parkingManagerService.makePaymentAndReleaseSpot(
                ticket.getTicketNumber(), PaymentMethod.UPI, amount
        );
        System.out.println("Parking flow completed for ticket: " + ticket.getTicketNumber());
    }

    private static ParkingSpot createSpot(String id, SpotType type) {
        return new ParkingSpot(id, type);
    }
}
