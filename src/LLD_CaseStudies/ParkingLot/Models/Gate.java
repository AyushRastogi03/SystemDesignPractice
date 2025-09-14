package LLD_CaseStudies.ParkingLot.Models;

import LLD_CaseStudies.ParkingLot.Enums.GateType;
import lombok.Getter;

@Getter
public class Gate {
    private String gateId;
    private GateType gateType;


    public Gate(String gateId, GateType gateType) {
        this.gateId = gateId;
        this.gateType = gateType;
    }


}
