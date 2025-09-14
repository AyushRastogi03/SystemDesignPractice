package LLD_CaseStudies.ParkingLot.Models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private String floorId;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public Floor(String floorId) {
        this.floorId = floorId;
    }

    public void addSpot(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
