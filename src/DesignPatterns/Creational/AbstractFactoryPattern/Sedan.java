package DesignPatterns.Creational.AbstractFactoryPattern;

public class Sedan implements Car{

    @Override
    public void assemble() {
        System.out.println("Sedan Car");
    }
}

class HatchBack implements Car{

    @Override
    public void assemble() {
        System.out.println("hatchBack Car");
    }
}

class NorthSpecification implements CarSpecification{

    @Override
    public void display() {
        System.out.println("North Specification");
    }
}

class SouthSpecification implements  CarSpecification{

    @Override
    public void display() {
        System.out.println("South Specification");
    }
}