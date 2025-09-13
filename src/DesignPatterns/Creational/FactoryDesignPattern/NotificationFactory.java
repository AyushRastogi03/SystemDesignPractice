package DesignPatterns.Creational.FactoryDesignPattern;

public class NotificationFactory {
    public Notification createNotification(String channel){
        if(channel.isEmpty() || channel == null){
            return null;
        }
        switch(channel){
            case "SMS":
                return new SMS();
            case "Email":
                return new Email();
            default:
                throw new IllegalArgumentException("Unknown channel - " + channel);

        }
    }
}
