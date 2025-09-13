package DesignPatterns.Creational.SingletonDesignPattern;

/*
Singleton Pattern is probably the most widely used design pattern.
It is a simple pattern, easy to understand and to use. Sometimes it is
used in excess and in scenarios where it is not required. In such cases,
the disadvantages of using it outweigh the advantages it brings. For this reason,
 the singleton pattern is sometimes considered an antipattern or pattern singleton.

 The Singleton method or Singleton Design pattern is one of the simplest
 design patterns. It ensures a class only has one instance, and provides a global point of access to it.

---------------------------
 Advantages of Singleton Design Pattern
 -----------------------------

Controlled Access to Instance
Ensures only one instance of the class is created and provides a global point of access.

Saves Memory and Resources
Prevents unnecessary object creation, reducing memory consumption and resource usage.

Thread-Safety (if implemented correctly)
In multithreaded applications, a thread-safe singleton ensures a consistent and reliable single instance.

Facilitates State Management
Useful for managing shared resources like configuration settings, logging, caching, or thread pools.

Global Access
The instance is globally accessible without requiring explicit passing or dependency injection.

Ease of Refactoring
Can easily replace or extend a singleton instance without significant changes to the dependent code.

------------------------
Disadvantages of Singleton Design Pattern
------------------------

Hidden Dependencies
The global instance can introduce hidden dependencies, making the code harder to read and test.

Testability Challenges
Singletons make unit testing difficult as they can't be easily mocked or replaced in test cases.

Concurrency Issues
Improper implementation in multithreaded environments can lead to race conditions or inconsistent behavior.

Tight Coupling
Classes dependent on a singleton instance are tightly coupled, reducing flexibility and increasing maintenance effort.

Violation of Single Responsibility Principle (SRP)
A singleton often acts as both a factory and a global object, violating SRP.

Global State Issues
Changes to the singleton's state can affect all parts of the program, leading to unpredictable behavior.

Summary
Within a Single JVM: Singleton works as expected.
Across Multiple JVMs/Instances: Singleton fails to guarantee a single instance.
 Use shared resources or distributed tools to ensure consistency.

Always evaluate whether a true singleton is necessary, especially in distributed environments,
 as enforcing it might add unnecessary complexity.
 */
public class MainClass {
    public static void main(String[] args) {
        Singleton single = Singleton.getInstance();
        single.doSomething();
    }
}
