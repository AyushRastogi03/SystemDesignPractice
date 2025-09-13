package DesignPatterns.Structural.ProxyDesignPattern;

/*
The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder
for another object to control access to it. This pattern is useful when you want to add an extra
layer of control over access to an object. The proxy acts as an intermediary, controlling access
to the real object.

When to Use the Proxy Pattern
Lazy Initialization: To delay the creation and initialization of a resource-intensive object until it is needed.
Access Control: To control access to the real object, such as adding security checks.
Remote Proxy: To represent an object that is located remotely.
Logging and Monitoring: To add logging or monitoring functionality when accessing the real object.
Caching: To add caching mechanisms for expensive operations.
Types of Proxies
Virtual Proxy: Controls access to a resource that is expensive to create or initialize.
Protection Proxy: Controls access to a resource based on access rights.
Remote Proxy: Represents an object that exists in a different address space.
Smart Proxy: Adds additional behavior when accessing the real object, such as reference counting or lazy initialization.
Benefits
Control Over Object Creation and Access: Provides control over how and when the real object is accessed or created.
Separation of Concerns: Separates additional responsibilities (e.g., access control, logging) from the main business logic.
Improves Performance: Can improve performance through lazy initialization or caching.
Drawbacks
Increased Complexity: Adds additional layers of complexity to the design.
Overhead: Introduces additional overhead due to the extra level of indirection.


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
