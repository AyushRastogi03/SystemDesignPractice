package DesignPatterns.Creational.FactoryDesignPattern;
/*
It is a creational design pattern that talks about the creation of an object. The factory design pattern says to define
an interface ( A java interface or an abstract class) for creating the object and let the subclasses decide which
class to instantiate.

This design pattern has been widely used in JDK, such as:

* getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern.
* All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using valueOf() method.
* java.nio.charset.Charset.forName(), java.sql.DriverManager#getConnection(), java.net.URL.openConnection(), java.lang.Class.newInstance(), java.lang.Class.forName() are some of their example where factory method design pattern has been used.


---------------------------
Advantages of Factory Design Pattern
--------------------------
1.Encapsulation of Object Creation Logic
The Factory pattern centralizes the logic for creating objects, making the codebase cleaner and easier to maintain.
Changes to the creation process affect only the factory, not the client code.

2.Loose Coupling
The client code depends on an abstract interface rather than concrete implementations. This promotes flexibility and scalability.
You can introduce new product types without altering existing client code.

3.Improved Code Reusability
The factory encapsulates the creation logic, which can be reused across the application, reducing code duplication.

4.Supports Open-Closed Principle
You can add new types of objects (new concrete implementations) without modifying existing code, keeping the system open for extension but closed for modification.

5.Improved Testing and Debugging
By centralizing object creation, you can mock or substitute dependencies during testing more easily.

6.Polymorphism Support
The factory can return different objects implementing the same interface, allowing clients to use polymorphism effectively.

-------------------
Disadvantages of Factory Design Pattern
-------------------
1.Increased Complexity
Introducing a factory adds an additional layer of abstraction, which can make the code more complex and harder to understand for beginners.

2.Overhead for Simple Applications
In small-scale applications, using a factory might be overkill, as it adds unnecessary boilerplate code.

3.Difficult to Extend Complex Factories
If the factory itself becomes too complex (handling too many product types), it can be challenging to maintain and extend.

4.Tight Coupling to Factory
Although the pattern decouples client code from specific implementations, it tightly couples the code to the factory itself.

5.May Violate Single Responsibility Principle
If a factory handles too many variations or product types, it might take on too much responsibility.


Use Case Consideration
When to use:

When the object creation process involves complex logic.
When you need to decouple the client code from the specific types being instantiated.
When adding new types or versions of objects in the future is likely.
When to avoid:

For simple object creation scenarios.
In small or lightweight applications where additional abstraction is unnecessary.

 */
public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}
