package DesignPatterns.Structural.DecoratorDesignPattern;

/*

Decorator design pattern allows us to dynamically add functionality and behavior to an object without
affecting the behavior of other existing objects within the same class. We use inheritance to extend
the behavior of the class. This takes place at compile-time, and all the instances of that class get
the extended behavior.

Real-World Use Cases:
Text Editors:
Apply formatting like bold, italic, or underline dynamically.
Streams in Java:
Classes in java.io package like BufferedReader, FileReader, InputStream, etc., are a classic example of the decorator pattern.
UI Components:
Adding scrollbars, borders, or shadows to graphical components.

Advantages:
Adheres to the Open/Closed Principle:
New functionality can be added without modifying the existing code.
Flexibility:
Multiple decorators can be applied dynamically in different combinations.
Reusability:
Individual decorators can be reused across different components.

Disadvantages:
Complexity:
Can result in a system with many small classes, making it harder to understand and maintain.
Order Sensitivity:
The order in which decorators are applied can affect the behavior.

 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle =  new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("cirlce with normal border ");

        circle.draw();

        System.out.println("circle with red border");

        redCircle.draw();

        System.out.println("Rectange with red border ");

        redRectangle.draw();

    }
}
