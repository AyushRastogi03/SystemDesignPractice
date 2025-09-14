package LLD_CaseStudies.ParkingLot.Models;

import LLD_CaseStudies.ParkingLot.Enums.SpotStatus;
import LLD_CaseStudies.ParkingLot.Enums.SpotType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Data
public class ParkingSpot {
     String id;
     SpotType spotType;
     SpotStatus spotStatus;
    final ReentrantLock lock = new ReentrantLock();

    public ParkingSpot(String id, SpotType type) { this.id = id; this.spotType = type; this.spotStatus = SpotStatus.AVAILABLE; }

}
