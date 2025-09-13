package DesignPatterns.Creational.AbstractFactoryPattern;
/*
The Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other.
 It provides a set of rules or instructions that let you create different types of things without knowing exactly what those things are.
 This helps you keep everything organized and lets you switch between different types easily, following the same set of rules.

Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over factory pattern.
Abstract Factory patterns work around a super-factory which creates other factories.
Abstract factory pattern implementation provides us with a framework that allows us to create objects that follow a general pattern.
So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.

---------------------------
Advantages of Abstract Factory Pattern
-----------------------

Encapsulation of Object Families
It encapsulates a group of related objects that are designed to work together, ensuring consistency and compatibility.

Loose Coupling
Client code is decoupled from the concrete implementation of products, relying only on abstract interfaces. This improves modularity and flexibility.

Easier to Introduce Variants
Adding a new family of related products is straightforward by introducing a new factory implementation without altering existing code.

Supports Open-Closed Principle
New product families can be added without modifying existing client code, making the system extensible.

Improved Code Reusability
Factories encapsulate the logic of object creation, promoting reuse and reducing duplication.

Polymorphism Support
The client can use polymorphism to interact with different families of objects through a consistent interface.

Centralized Control
Object creation logic is centralized in factories, making it easier to manage and maintain.

---------------------------
Disadvantages of Abstract Factory Pattern
--------------------------

Increased Complexity
The pattern introduces additional layers of abstraction, making the codebase more complex and harder to understand for newcomers.

Overhead for Simple Applications
In small or lightweight applications, the Abstract Factory can add unnecessary boilerplate and make the solution over-engineered.

Harder to Add New Products
While adding new families of products is easy, adding new types of products to existing families requires changes to all existing factories, which may violate the Open-Closed Principle.

Maintenance Overhead
If many factories are needed for different product families, managing them can become challenging.

Rigid Hierarchy
The pattern imposes a strict hierarchy, which might not be suitable for all use cases, especially when products or their relationships are dynamic.

Use Case Consideration
When to Use:

When your application requires creating families of related objects.
When you need consistency among objects in a product family.
When introducing new families of products is a common requirement.
When to Avoid:

For applications with simple or single-product creation logic.
When adding new types of products frequently is more likely than adding new families.
 */
public class CarFactoryClient {
    public static void main(String[] args) {
        CarFactory carFactory = new NorthCarFactory();
        Car northCar = carFactory.createCar();

        CarSpecification northSpecification = carFactory.createSpecification();

        northCar.assemble();
        northSpecification.display();

        CarFactory southCarFac = new SouthCarFactory();
        Car southCar = southCarFac.createCar();

        CarSpecification southSpec = new SouthSpecification();
        southCar.assemble();
        southSpec.display();
    }
}
