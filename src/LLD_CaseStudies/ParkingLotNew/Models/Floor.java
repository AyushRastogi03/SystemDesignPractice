package LLD_CaseStudies.ParkingLotNew.Models;

import lombok.Data;

import java.util.List;

@Data
public class Floor {

    private String floorId;

    private List<ParkingSpot> parkingSpotList;


}
