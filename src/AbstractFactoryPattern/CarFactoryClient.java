package AbstractFactoryPattern;
/*
The Abstract Factory Pattern is a way of organizing how you create groups of things that are related to each other.
 It provides a set of rules or instructions that let you create different types of things without knowing exactly what those things are.
 This helps you keep everything organized and lets you switch between different types easily, following the same set of rules.

Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction over factory pattern.
Abstract Factory patterns work around a super-factory which creates other factories.
Abstract factory pattern implementation provides us with a framework that allows us to create objects that follow a general pattern.
So at runtime, the abstract factory is coupled with any desired concrete factory which can create objects of the desired type.
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
