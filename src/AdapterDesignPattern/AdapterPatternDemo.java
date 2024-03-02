package AdapterDesignPattern;


/*
Adapter pattern works as a bridge between two incompatible interfaces.
This type of design pattern comes under structural pattern as this pattern
combines the capability of two independent interfaces.

* Structural Design Pattern
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        CreditCard creditCard = new BankCustomer();
        creditCard.giveBankDetails();
        System.out.println(creditCard.getCreditCard());
    }
}
