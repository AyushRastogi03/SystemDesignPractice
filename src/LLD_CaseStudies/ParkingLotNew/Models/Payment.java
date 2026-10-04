package LLD_CaseStudies.ParkingLotNew.Models;

import LLD_CaseStudies.ParkingLotNew.Enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment {

    private String paymentId;

    private Double paymentAmount;

    private PaymentStatus paymentStatus;
}
