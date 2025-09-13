# SystemDesignPractice

Design patterns Categorization :- 

1. Creational Pattern 
   - Factory 
   - Abstract Factory
   - Singleton
   - Builder
   - Prototype.

2. Structural Pattern 
   - Adaptor
   - Bridge
   - Composite
   - Decorator
   - Facade 
   - Flyweight.
   - Proxy 

3. Behavioural Pattern
   - Chain Of Responsibility .
   - Command 
   - Interpreter.
   - Iterator
   - Mediator.
   - Momento.
   - Observer
   - State.
   - Strategy
   - Template
   - Visitor.

-----------------------

1. Creational Patterns
   These deal with object creation mechanisms.

Singleton Pattern
Ensures that a class has only one instance and provides a global point of access to it.
Example: Runtime.getRuntime()
Factory Pattern
Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
Example: Calendar.getInstance()
Builder Pattern
Builds complex objects step by step and allows more control over object creation.
Example: StringBuilder or StringBuffer
Prototype Pattern
Creates a duplicate object while keeping performance in mind.
Example: Implementing Cloneable in Java.
Abstract Factory Pattern
Provides a way to encapsulate a group of individual factories.


2. Structural Patterns
   These deal with object composition.

Adapter Pattern
Bridges two incompatible interfaces.
Example: Wrapping a legacy API.
Decorator Pattern
Adds new functionality to an object dynamically.
Example: BufferedReader decorating Reader.
Proxy Pattern
Provides a placeholder or surrogate to control access to an object.
Example: Dynamic proxies in Java.
Composite Pattern
Composes objects into tree structures to represent part-whole hierarchies.
Example: File system directories and files.
Facade Pattern
Provides a simplified interface to a larger subsystem.
Flyweight Pattern
Minimizes memory use by sharing objects.
Bridge Pattern
Decouples abstraction from implementation.



3. Behavioral Patterns
   These deal with object interaction and communication.

Observer Pattern
Defines a dependency between objects so that when one object changes state, all its dependents are notified.
Example: Observer and Observable in Java.
Strategy Pattern
Defines a family of algorithms and makes them interchangeable.
Example: Sorting algorithms.
Command Pattern
Encapsulates requests as objects, allowing parameterization and queuing.
Example: Undo functionality.
Template Method Pattern
Defines the skeleton of an algorithm, deferring steps to subclasses.
Example: HttpServlet.doGet() and doPost().
Chain of Responsibility Pattern
Passes a request along a chain of handlers.
Example: Servlet Filters.
State Pattern
Allows an object to alter its behavior when its internal state changes.
Mediator Pattern
Reduces communication complexity between multiple objects by centralizing communication.

Not all patterns are used equally. Focus on these most commonly used:

Singleton
Factory
Observer
Strategy
Decorator
These are foundational and appear frequently in real-world projects.
-----------------------

🔹 1. Big Picture of Design Patterns

Design patterns are grouped into three families:

Category	Focus	            Question it answers
----------------------------------------------------------
Creational	Object creation	    How do I create objects?
Structural	Object composition	How do I combine objects into bigger structures?
Behavioral	Object interaction	How do objects communicate / which algorithm to use?
----------------------

🔹 2. Creational Patterns (Object Creation)

👉 Use them when object creation logic is complex, variable, or hidden.

Factory Method → Which class should I instantiate?
Example: Payment factory decides whether to give you CardPayment or UPIPayment.

Abstract Factory → Create related families of objects.
Example: UI themes (WindowsButton + WindowsCheckbox vs MacButton + MacCheckbox).

Singleton → Only one instance allowed.
Example: Database connection pool.

Builder → Step-by-step object creation.
Example: Building a complex object like Car with engine, wheels, seats.

Prototype → Clone existing objects.
Example: Duplicating game characters with slight changes.

✅ Rule of thumb:
If you ask yourself “which object should I create, and how?” → You need a Creational Pattern.

--------------
🔹 3. Structural Patterns (Composition)

👉 Use them when you want to organize and connect objects/classes efficiently.

Adapter → Convert one interface into another.
Example: A power adapter that lets you plug EU charger into US socket.

Decorator → Add behavior dynamically without changing the class.
Example: Coffee → add milk → add sugar.

Facade → Provide a simplified interface to a complex system.
Example: A HomeTheaterFacade controls DVD, projector, speakers with one method watchMovie().

Proxy → Stand-in object to control access.
Example: Virtual proxy for lazy-loading images.

Composite → Treat individual and group objects uniformly.
Example: File system (File vs Folder).

✅ Rule of thumb:
If you ask yourself “how do I organize multiple classes/objects into a bigger structure?” → You need a Structural Pattern.

----------------
🔹 4. Behavioral Patterns (Interaction/Algorithms)

👉 Use them when you want to define how objects communicate, or allow flexible behavior changes.

Strategy → Choose algorithm at runtime.
Example: Payment with UPI vs Card vs NetBanking.

Observer → Publish-subscribe.
Example: UI button click → all listeners notified.

Template Method → Define algorithm steps, let subclasses fill in details.
Example: Data parsing template (open → read → close).

Chain of Responsibility → Pass a request along a chain until one handles it.
Example: Logging (console → file → DB).

Command → Encapsulate requests as objects.
Example: Undo/redo actions.

Mediator → Central hub for communication.
Example: Air traffic control tower.

✅ Rule of thumb:
If you ask yourself “how should objects communicate or which algorithm should be applied?” → You need a Behavioral Pattern.

✅ Example: Payment Gateway

Factory → Creates the right payment method object (Card/UPI/NetBanking).

Strategy → Decides how the payment is executed.

Observer → Notify user + send email + update dashboard.

Facade → Simplify access to complex APIs.

In a real system, you often combine multiple patterns.
------------------------------------