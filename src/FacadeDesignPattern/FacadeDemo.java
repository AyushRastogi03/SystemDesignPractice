package FacadeDesignPattern;
/*
* Structural Design pattern
* acade Method Design Pattern provides a unified interface to a set
* of interfaces in a subsystem. Facade defines a high-level
* interface that makes the subsystem easier to use.
*
*
 */
public class FacadeDemo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        DeliveryService deliveryService = new DeliveryService();

        FoodDeliveryFacade foodDeliveryFacade = new FoodDeliveryFacade(restaurant,deliveryService);

        foodDeliveryFacade.placeOrder();
    }
}
