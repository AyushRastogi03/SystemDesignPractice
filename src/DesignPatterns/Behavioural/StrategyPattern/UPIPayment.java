package DesignPatterns.Behavioural.StrategyPattern;

public class UPIPayment implements PaymentMethod{
    @Override
    public void payment() {
        System.out.println("UPI Payment class");
    }
}
