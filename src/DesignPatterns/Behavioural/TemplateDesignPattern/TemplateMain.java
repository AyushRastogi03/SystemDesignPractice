package DesignPatterns.Behavioural.TemplateDesignPattern;

/*
The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm or
operations in a superclass (often abstract) and leaves the details to be implemented by the child classes.
It allows subclasses to customize specific parts of the algorithm without altering its overall structure.

Advantages
Code Reusability:
Common parts of the algorithm are implemented in the base class.
Consistency:
Ensures the overall structure of the algorithm is consistent.
Flexibility:
Allows subclasses to customize specific steps without affecting others.


Disadvantages
Limited Scope for Variation:
The overall structure of the algorithm cannot be altered.
Inheritance-Based:
Tight coupling between the base class and subclasses due to inheritance.



Real-World Use Cases
Framework Design:
Frameworks often provide a template for common tasks, like opening files or setting up network connections.
Game Development:
Games can have common setup, turn execution, and ending logic, with game-specific rules implemented in subclasses.
Data Processing Pipelines:
A base class defines the structure of processing data, while subclasses handle specific formats (e.g., JSON, XML).

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
