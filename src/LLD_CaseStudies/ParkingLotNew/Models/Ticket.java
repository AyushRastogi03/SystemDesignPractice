package LLD_CaseStudies.ParkingLotNew.Models;

import LLD_CaseStudies.ParkingLotNew.Enums.TicketStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Ticket {

    private String ticketNumber;

    private TicketStatus ticketStatus;

    private Vehicle vehicle;

    private Payment payment;

    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private Gate entryGate;

    private Gate exitGate;

    /** Protects payment and close operations for this ticket. */
    @EqualsAndHashCode.Exclude
    private final ReentrantLock lifecycleLock = new ReentrantLock();


}
