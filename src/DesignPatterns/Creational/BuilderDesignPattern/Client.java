package DesignPatterns.Creational.BuilderDesignPattern;


/*
The Builder design pattern is a creational design pattern that provides a way
to construct complex objects step by step. It separates the construction of a complex object from its
representation, allowing the same construction process to create different representations.
It is used when you want to create an object with many optional parameters or complex configurations
 but want to avoid having a constructor with many arguments

When to Use the Builder Pattern
Complex Object Creation: When creating complex objects that require multiple steps.
Immutable Objects: When building immutable objects with many optional parameters.
Different Representations: When the same construction process must create different representations of the product.
Benefits
Control Over Construction Process: Provides better control over the construction process.
Separation of Concerns: Separates the code for construction and representation.
Flexibility: Allows for different representations of the object using the same construction process.
Readable Code: Makes the client code easier to read and maintain.
Drawbacks
Complexity: Introduces additional complexity with multiple classes and interfaces.
Overhead: Can be overkill for simpler objects with fewer construction steps.


 */
public class Client {
    public static void main(String[] args) {
        HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder();
        ConstructionEngineer engineer = new ConstructionEngineer(concreteHouseBuilder);

        House house1 = engineer.constructHouse();
        System.out.println(concreteHouseBuilder.getHouse());
        System.out.println("House is: " + house1);

        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        engineer = new ConstructionEngineer(woodenHouseBuilder);

        House house2 = engineer.constructHouse();
        System.out.println("House is: " + house2);
    }
}
