package LLD_CaseStudies.ParkingLotNew.Models;

import LLD_CaseStudies.ParkingLotNew.Enums.GateType;
import lombok.Data;

@Data
public class Gate {

    private String gateId;

    private GateType gateType;


}
