package DesignPatterns.Creational.AbstractFactoryPattern;

public interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}
