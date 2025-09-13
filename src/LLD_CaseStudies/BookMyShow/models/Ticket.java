package LLD_CaseStudies.BookMyShow.models;

import java.util.Date;

public class Ticket {

    private static int idCounter = 0;
    private int id;
    private Date bookTime;
    private Theater theatre;
    private int noOfSeat;

    private Show bookedShow;

    public Ticket(Date bookTime, Theater theatre, int noOfSeat) {
        idCounter = idCounter+ 1;
        this.id = idCounter;
        this.bookTime = bookTime;
        this.theatre = theatre;
        this.noOfSeat = noOfSeat;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Theater getTheatre() {
        return theatre;
    }

    public void setTheatre(Theater theatre) {
        this.theatre = theatre;
    }

    public int getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(int noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public Show getBookedShow() {
        return bookedShow;
    }

    public void setBookedShow(Show bookedShow) {
        this.bookedShow = bookedShow;
    }

    public String getTicketDetails(){
        return "Ticket Details - "+this.noOfSeat+" - "+ this.theatre;
    }

    public int cancelTickets(){
        this.theatre = null;
        this.bookedShow = null;
        this.noOfSeat=0;

        System.out.println("Ticket got cancelled");
        return 1;
    }
}
