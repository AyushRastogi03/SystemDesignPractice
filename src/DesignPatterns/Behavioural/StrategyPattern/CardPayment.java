package DesignPatterns.Behavioural.StrategyPattern;

public class CardPayment implements PaymentMethod{
    @Override
    public void payment() {
        System.out.println("Card Payment class");
    }
}
