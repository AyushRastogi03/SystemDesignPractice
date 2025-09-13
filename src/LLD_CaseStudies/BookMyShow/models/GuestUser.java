package LLD_CaseStudies.BookMyShow.models;

public class GuestUser extends User{

    private boolean isRegistered;

    public GuestUser(String name) {
        super(name);
        this.isRegistered =false;
    }
    // hello word


    public void register(String name , String email , String password){
         isRegistered= true;
    }
}
