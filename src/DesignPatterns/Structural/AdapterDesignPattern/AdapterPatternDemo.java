package DesignPatterns.Structural.AdapterDesignPattern;


/*
Adapter pattern works as a bridge between two incompatible interfaces.
This type of design pattern comes under structural pattern as this pattern
combines the capability of two independent interfaces.

--> when we dont want to touch the legacy code but build the feature above
that using that then we use adapter design pattern

* Structural Design Pattern

How It Works:
The client interacts with the adapter.
The adapter translates the client’s requests into the format that the adaptee can understand.
The adaptee performs the actual operation and returns the result to the adapter, which is passed back to the client.

Real-World Use Cases:
Adapters for Legacy Code: Integrating modern systems with older legacy systems.
APIs and Libraries: Using third-party libraries that do not follow your system's interface.
Device Drivers: Translating requests from applications into a format understood by hardware.

Advantages:
Reusability: Adapts existing classes to work under a new system without modifying their source code.
Flexibility: Allows different classes to work together by resolving interface incompatibilities.
Decoupling: Separates the client and adaptee, enabling independent evolution of both.

Disadvantages:
Increased Complexity: Adds an extra layer, which may increase the complexity of the code.
Performance Overhead: May introduce slight performance overhead due to the additional layer of translation.
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        CreditCard creditCard = new BankCustomer();
        creditCard.giveBankDetails();
        System.out.println(creditCard.getCreditCard());
    }
}
