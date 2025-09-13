package DesignPatterns.Behavioural.CommandDesignPattern;

// concrete receiver
public class TV implements Device{
    @Override
    public void turnOn() {
        System.out.println("TV is on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is off");
    }

    public void changeChannel(){
        System.out.println("channel changed");
    }
}
