package LLD_CaseStudies.BookMyShow;

import LLD_CaseStudies.BookMyShow.Enums.Genre;
import LLD_CaseStudies.BookMyShow.Enums.Language;
import LLD_CaseStudies.BookMyShow.models.*;
import java.util.*;

public class BookMyShowMain {
    public static void main(String[] args) {
        RegisteredUser user = new RegisteredUser("Ayush");
        RegisteredUser user2 = new RegisteredUser("Ram");

        GuestUser guestUser = new GuestUser("Sam");

        Movie movie = new Movie("RRR", Language.ENGLISH, Genre.ACTION);
        Movie movie1 = new Movie("PK",Language.HINDI,Genre.COMEDY);

        Theater theater = new Theater("PVR","GIP mall", 30);
        Theater theater1 = new Theater("INOX", "VV mall", 40);

        Show show = new Show(new Date(),movie,theater);
        Show show1 = new Show(new Date(),movie1,theater1);

        // search show
        BookMyShow bookMyShow = new BookMyShow(new ArrayList<>(Arrays.asList(theater,theater1)));
        try {
           ArrayList<Show> showArrayList = bookMyShow.searchShow(movie.getName());
            System.out.println(showArrayList.toString());
        }catch (Exception e){
            System.out.println("Movie not found");
        }

        //book ticket
        try{
            Ticket ticket = bookTicketMethod(show , theater, 24,user);
            System.out.println("Ticket booked - "+ ticket.getTicketDetails());
        }catch(Exception exception){
            System.out.println("Ticket is not available");
        }
    }

    //book ticket method ;
    private static Ticket bookTicketMethod(Show show , Theater theater, int seat , RegisteredUser user) throws Exception {
         if(user instanceof RegisteredUser){
                  return show.bookTicket(seat, user,theater) ;
         }else {
             throw new Exception("User is not Registered Please register first");

         }
    }
}
