package DesignPatterns.Creational.AbstractFactoryPattern;

public class NorthCarFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public CarSpecification createSpecification() {
        return new NorthSpecification();
    }
}

class SouthCarFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new HatchBack();
    }

    @Override
    public CarSpecification createSpecification() {
        return new SouthSpecification();
    }
}
