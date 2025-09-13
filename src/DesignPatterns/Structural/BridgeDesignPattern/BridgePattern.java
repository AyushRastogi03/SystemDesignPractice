package DesignPatterns.Structural.BridgeDesignPattern;
/*
The Bridge design pattern allows you to separate the abstraction
 from the implementation. It is a structural design pattern.

There are 2 parts in Bridge design pattern :
Abstraction
Implementation

Real-World Use Cases:
UI Components:
Separating UI widgets (e.g., buttons, checkboxes) from their platform-specific rendering implementations.
Database Drivers:
Abstracting SQL queries from database-specific implementations.
Media Players:
Decoupling media formats from their rendering engines.

Advantages:
Independence:
Abstraction and implementation can be developed independently.
Scalability:
Easily extend both abstraction and implementation hierarchies.
Reduces Code Duplication:
Avoids the explosion of subclasses seen in other patterns.

Disadvantages:
Complexity:
Increases the overall complexity of the code due to additional layers of abstraction.
Overhead:
May introduce a slight performance cost due to indirection.


 */
public class BridgePattern {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(new Produce(), new Assemble());
        vehicle.manufacture();

        Vehicle vehicle1 = new Bike(new Produce(),new Assemble());
        vehicle1.manufacture();
    }
}
