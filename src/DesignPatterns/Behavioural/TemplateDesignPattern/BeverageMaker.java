package DesignPatterns.Behavioural.TemplateDesignPattern;

public abstract class BeverageMaker {
    public final void makeBeverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }

}
