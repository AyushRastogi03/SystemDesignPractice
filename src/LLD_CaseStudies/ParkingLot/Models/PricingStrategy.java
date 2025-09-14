package LLD_CaseStudies.ParkingLot.Models;

public interface PricingStrategy {
    public double calculate(ParkingTicket ticket);
}
