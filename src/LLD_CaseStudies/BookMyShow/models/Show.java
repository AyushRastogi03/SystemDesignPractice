package LLD_CaseStudies.BookMyShow.models;

import java.util.Date;

public class Show {

    private static int idCounter = 0;
    private int id;
    private Date showtime;
    private int availableSeat;

    private Movie movie;
    private Theater theater;

    public Show(Date showtime, Movie movie, Theater theater) {
        idCounter =  idCounter + 1;
        this.id = idCounter;
        this.showtime = showtime;
        this.movie = movie;
        this.theater = theater;
        this.availableSeat = theater.getCapacity();
        theater.getShows().add(this);
    }

    @Override
    public String toString() {
        return "Show{" +
                "date=" + showtime +
                ", movie=" + movie +
                ", theater=" + theater +
                '}';
    }

    public Date getShowtime() {
        return showtime;
    }

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Ticket bookTicket(int seat , RegisteredUser registeredUser , Theater theater ) throws Exception {
        if(this.availableSeat<seat){
            throw new Exception("Seat not available");
        }
        Ticket ticket = new Ticket(new Date(),theater,seat);
        this.availableSeat = this.availableSeat - seat;
        System.out.println("Ticket booked successfully");
        return ticket;
    }
}
