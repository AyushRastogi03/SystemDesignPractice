package TemplateDesignPattern;

/*
The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm or
operations in a superclass (often abstract) and leaves the details to be implemented by the child classes.
It allows subclasses to customize specific parts of the algorithm without altering its overall structure.
 */
public class TemplateMain {
    public static void main(String[] args) {
        System.out.println("Making tea");
        BeverageMaker beverageMaker = new TeaMaker();
        beverageMaker.makeBeverage();

        System.out.println("Coffee Making");
        BeverageMaker beverageMaker1 = new CoffeeMaker();
        beverageMaker1.makeBeverage();
    }
}
