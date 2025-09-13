package LLD_CaseStudies.BookMyShow.models;

import java.util.ArrayList;

public class RegisteredUser extends User{

    private boolean isLoggedin;
    private ArrayList<Ticket> bookingHistory;

    public RegisteredUser(String name) {
        super(name);
        this.bookingHistory = new ArrayList<>();
        isLoggedin = false;
    }

    public void isLoggedIn(String name , String password){
       isLoggedin = true;
    }
}
