package LLD_CaseStudies.ParkingLot.Models;


import LLD_CaseStudies.ParkingLot.Enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@AllArgsConstructor
@Data
public class ParkingTicket {
    private String id;
    private String spotId;
    private Vehicle vehicle;
    volatile Instant inTime;
    volatile Instant outTime;
    volatile TicketStatus status;
    volatile double amount;

    ParkingTicket(String ticketId, String spotId, Vehicle v) {
        this.id = ticketId; this.spotId = spotId; this.vehicle = v;
        this.inTime = Instant.now(); this.status = TicketStatus.PENDING;
    }
}
