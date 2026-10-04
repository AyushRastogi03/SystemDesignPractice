package LLD_CaseStudies.ParkingLotNew.Models;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    private String parkingLotId;

    private List<Floor> parkingFloors;

    private List<Gate> entryGates;

    private List<Gate> exitGates;

}
