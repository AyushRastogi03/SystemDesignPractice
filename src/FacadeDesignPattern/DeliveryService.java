package FacadeDesignPattern;

public class DeliveryService {
    public void assignDeliveryGuy(){
        System.out.println("deliveryGuyAssigned");
    }

    public void pickUpOrder(){
        System.out.println("Order pickUp");
    }

    public void deliveryOrder(){
        System.out.println("Deliver Order");
    }
}
