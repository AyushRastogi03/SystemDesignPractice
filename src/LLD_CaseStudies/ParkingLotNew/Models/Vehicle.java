package LLD_CaseStudies.ParkingLotNew.Models;

import LLD_CaseStudies.ParkingLotNew.Enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {

    private String vehicleNumber;

    private VehicleType vehicleType;
}
