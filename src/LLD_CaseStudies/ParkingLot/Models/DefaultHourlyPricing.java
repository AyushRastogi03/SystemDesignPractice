package LLD_CaseStudies.ParkingLot.Models;

import java.time.Instant;

public class DefaultHourlyPricing implements PricingStrategy {
    private final double hourlyRate;
    public DefaultHourlyPricing(double hourlyRate) { this.hourlyRate = hourlyRate; }


    public double calculate(ParkingTicket t) {
        Instant out = (t.outTime != null) ? t.outTime : Instant.now();
        long secs = java.time.Duration.between(t.inTime, out).getSeconds();
        double hours = Math.ceil(secs / 3600.0);
        return hours * hourlyRate;
    }
}
