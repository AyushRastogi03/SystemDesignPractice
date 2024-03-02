package StrategyPattern;
/*Stategy Design Pattern --
*
*Behaviour of an object is being selected at run time
*
*/
public class Payments {
    public static void main(String[] args) {
       PaymentContext paymentContext = new PaymentContext(new CardPayment());
       paymentContext.performPayment();

       paymentContext.setPaymentMethod(new UPIPayment());
       paymentContext.performPayment();
    }
}
