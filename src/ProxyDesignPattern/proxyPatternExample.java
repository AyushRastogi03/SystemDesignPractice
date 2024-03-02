package ProxyDesignPattern;

/*
The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder
for another object to control access to it. This pattern is useful when you want to add an extra
layer of control over access to an object. The proxy acts as an intermediary, controlling access
to the real object.

refer GFG - for why we need this design pattern and pros/cons
 */
public class proxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        // image will be loaded from disk
        image.display();

        // image will not be loaded from disk , as it is being cached in proxy
        image.display();
    }
}
