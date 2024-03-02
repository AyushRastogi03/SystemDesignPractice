package DecoratorDesignPattern;

/*

Decorator design pattern allows us to dynamically add functionality and behavior to an object without
affecting the behavior of other existing objects within the same class. We use inheritance to extend
the behavior of the class. This takes place at compile-time, and all the instances of that class get
the extended behavior.

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
