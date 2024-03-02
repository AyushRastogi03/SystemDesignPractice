package ObserverDesignPattern;
/*
* The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency
*  between objects so that when one object (the subject) changes state,
* all its dependents (observers) are notified and updated automatically.
*
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
