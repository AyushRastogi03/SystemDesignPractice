package DesignPatterns.Structural.FacadeDesignPattern;


//Facade class
public class FoodDeliveryFacade {
    Restaurant restaurant;
    DeliveryService deliveryService;

    public FoodDeliveryFacade(Restaurant restaurant,DeliveryService deliveryService){
        this.deliveryService = deliveryService;
        this.restaurant = restaurant;
    }

    public void placeOrder(){
        deliveryService.assignDeliveryGuy();
        restaurant.prepareFood();
        deliveryService.pickUpOrder();
        deliveryService.deliveryOrder();
    }
}
