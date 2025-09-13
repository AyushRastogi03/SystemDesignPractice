package DesignPatterns.Behavioural.TemplateDesignPattern;

public class CoffeeMaker extends BeverageMaker{
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
