package ObserverDesignPattern;

public class Phone implements Observer{
    private String weather;
    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display(){
        System.out.println("Phone :: Weather -  " + weather);
    }
}
