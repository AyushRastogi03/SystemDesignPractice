package BridgeDesignPattern;
/*
The Bridge design pattern allows you to separate the abstraction
 from the implementation. It is a structural design pattern.

There are 2 parts in Bridge design pattern :
Abstraction
Implementation


 */
public class BridgePattern {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(new Produce(), new Assemble());
        vehicle.manufacture();

        Vehicle vehicle1 = new Bike(new Produce(),new Assemble());
        vehicle1.manufacture();
    }
}
