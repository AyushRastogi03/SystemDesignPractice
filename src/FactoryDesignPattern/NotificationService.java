package FactoryDesignPattern;
/*
It is a creational design pattern that talks about the creation of an object. The factory design pattern says to define
an interface ( A java interface or an abstract class) for creating the object and let the subclasses decide which
class to instantiate.

This design pattern has been widely used in JDK, such as:

* getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern.
* All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using valueOf() method.
* java.nio.charset.Charset.forName(), java.sql.DriverManager#getConnection(), java.net.URL.openConnection(), java.lang.Class.newInstance(), java.lang.Class.forName() are some of their example where factory method design pattern has been used.
 */
public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}
