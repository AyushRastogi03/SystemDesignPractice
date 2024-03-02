package StrategyPattern;

public class PaymentContext {
    private PaymentMethod paymentMethod;

    public PaymentContext(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void performPayment(){
        paymentMethod.payment();
    }
}
