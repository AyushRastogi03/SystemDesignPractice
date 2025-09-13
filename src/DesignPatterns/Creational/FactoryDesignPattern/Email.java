package DesignPatterns.Creational.FactoryDesignPattern;

public class Email implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Email Notification");
    }
}
