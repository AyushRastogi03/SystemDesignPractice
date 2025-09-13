package DesignPatterns.Structural.FacadeDesignPattern;
/*
* Structural Design pattern
* Facade Method Design Pattern provides a unified interface to a set
* of interfaces in a subsystem. Facade defines a high-level
* interface that makes the subsystem easier to use.
*
* The Facade design pattern is a structural pattern that provides a simplified interface to a complex subsystem.
* It defines a higher-level interface that makes the subsystem easier to use by hiding its complexity.
*  The Facade pattern is often used to wrap a set of complex or interdependent classes into a single well-defined API.
*
* When to Use the Facade Pattern
Simplify Complex Subsystems: When you want to provide a simple interface to a complex subsystem.
Decouple Clients from Subsystems: When you want to decouple clients from the complex subsystem, making the system easier to use.
Layering Systems: When you want to layer your subsystems and use facades to provide a unified interface to a set of interfaces in a subsystem.
Benefits
Simplifies Usage: Provides a simple interface to a complex subsystem.
Decouples Code: Decouples the client code from the subsystem, reducing dependencies.
Reduces Complexity: Helps manage the complexity of a system by dividing it into subsystems and using facades to interact with them.
Drawbacks
Potentially Limited Functionality: The facade might provide limited functionality compared to the subsystem's full capabilities.
Performance Overhead: Adding an additional layer can introduce performance overhead.
*
*
Real-World Use Cases:
Database Connection:
A facade can manage the complexities of opening, executing, and closing database connections.
Frameworks:
Spring Framework’s JdbcTemplate acts as a facade to simplify database operations.
UI Libraries:
Facades are used to simplify complex graphical or animation systems.
APIs:
A payment gateway library may offer a facade to abstract away low-level
 payment validation, encryption, and transaction details.
*
*
* Advantages:
Simplified Interface:
Hides the complexities of the subsystem and provides a clean interface.
Decoupling:
Reduces dependency between client code and subsystem classes.
Improves Maintenance:
Easier to update or replace subsystems without impacting client code.
Reusability:
Common interactions are encapsulated in a reusable facade.
*
*
Disadvantages:
Limited Subsystem Access:
May not expose all features of the subsystem.
Additional Layer:
Adds another layer, which may slightly impact performance.
Overhead:
If the subsystem is simple, a facade may introduce unnecessary abstraction.

 */
//Client
public class FacadeDemo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        DeliveryService deliveryService = new DeliveryService();

        FoodDeliveryFacade foodDeliveryFacade = new FoodDeliveryFacade(restaurant,deliveryService);

        foodDeliveryFacade.placeOrder();
    }
}
