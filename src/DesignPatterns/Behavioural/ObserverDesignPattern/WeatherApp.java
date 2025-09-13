package DesignPatterns.Behavioural.ObserverDesignPattern;
/*
* The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency
*  between objects so that when one object (the subject) changes state,
* all its dependents (observers) are notified and updated automatically.
*
*
* Real-World Use Cases:
*
Event Listeners:
GUI components reacting to user actions.
Publish/Subscribe Systems:
Messaging systems like Kafka or RabbitMQ.
Stock Market Applications:
Investors observing changes in stock prices.
News Feeds:
Social media platforms notifying users of updates.
*
*
Advantages:
Loose Coupling:
Observers and subjects are loosely coupled, allowing independent development.
Dynamic Relationships:
Observers can be added or removed at runtime.
Scalability:
Multiple observers can observe the same subject.
*
*
Disadvantages:
Memory Leaks:
If observers are not properly deregistered, memory leaks can occur.
Unexpected Updates:
Observers may receive updates they don’t need if they lack proper filtering mechanisms.
Performance Overhead:
Notifying a large number of observers can slow down the system.

* */
public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Observer phone =  new Phone();
        Observer TV = new TVDisplay();

        weatherStation.addObserver(phone);
        weatherStation.addObserver(TV);

        weatherStation.setWeather("Cold");
    }
}
