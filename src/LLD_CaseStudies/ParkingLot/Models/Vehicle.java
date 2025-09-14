package LLD_CaseStudies.ParkingLot.Models;

import LLD_CaseStudies.ParkingLot.Enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Vehicle {
    private String id;
    private VehicleType vehicleType;
    private String licensePlate;

    public Vehicle(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

}
