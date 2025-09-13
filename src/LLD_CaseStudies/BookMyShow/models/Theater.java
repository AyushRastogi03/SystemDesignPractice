package LLD_CaseStudies.BookMyShow.models;

import java.util.ArrayList;

public class Theater {
    private static int idCounter = 0;
    private int id ;
    private String name;
    private String location;
    private int capacity;

    private ArrayList<Show> shows;

    public Theater(String name, String location, int capacity) {
        idCounter = idCounter + 1;
        this.id = idCounter;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.shows = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Show{" +
                "name=" + name +
                ", location=" + location +
                ", capacity=" + capacity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public void updateShows(Show oldShow , Show newShow){
        if(this.shows.contains(oldShow)){
            this.shows.remove(oldShow);
            this.shows.add(newShow);
        }else{
            System.out.println("No show with name - "+ oldShow);
        }
    }
}
