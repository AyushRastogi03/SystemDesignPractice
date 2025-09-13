package DesignPatterns.Behavioural.CommandDesignPattern;


// concrete receiver
public class Stereo implements Device{
    @Override
    public void turnOn() {
        System.out.println("Stereo is on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is off");
    }

    public void adjustVolume(){
        System.out.println("volume Changed");
    }
}
