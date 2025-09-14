package LLD_CaseStudies.ParkingLot;

import LLD_CaseStudies.ParkingLot.Enums.GateType;
import LLD_CaseStudies.ParkingLot.Enums.SpotType;
import LLD_CaseStudies.ParkingLot.Enums.VehicleType;
import LLD_CaseStudies.ParkingLot.Models.*;

public class ParkingLotMain {
    public static void main(String[] args) {
        PricingStrategy pricing = new DefaultHourlyPricing(20.0);
        ParkingManager manager = new ParkingManager("M1", pricing);
        ParkingLot lot = new ParkingLot("L1", "Oracle Campus Lot", manager);

        // Floor 1
        Floor f1 = new Floor("F1");
        f1.addSpot(new ParkingSpot("S1", SpotType.COMPACT));
        f1.addSpot(new ParkingSpot("S2", SpotType.LARGE));
        f1.addSpot(new ParkingSpot("S3", SpotType.MOTORCYCLE));
        lot.addFloor(f1);

        // Gates
        lot.addEntryGate(new Gate("E1", GateType.ENTRY));
        lot.addExitGate(new Gate("X1", GateType.EXIT));

        // Example usage
        Vehicle car = new Vehicle("KA-01-1234", VehicleType.CAR);
        ParkingTicket ticket = lot.getManager().parkVehicle(car);
        System.out.println("Ticket issued: " + ticket.getId());

        lot.getManager().confirmPayment(ticket.getId());
        double amount = lot.getManager().unpark(ticket.getId());
        System.out.println("Paid: " + amount);
    }
}
