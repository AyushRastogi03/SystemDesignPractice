package LLD_CaseStudies.BookMyShow.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class BookMyShow {
    private ArrayList<User> users;
    private ArrayList<Theater> theaters;

    private HashMap<String , ArrayList<Show>> movieMap;

    public BookMyShow(ArrayList<Theater> theaters) {
        this.users = new ArrayList<>();
        this.theaters = theaters;
        this.movieMap = new HashMap<>();
        generateMovieMap();
    }

    private void generateMovieMap(){
        for(Theater theater : this.theaters){
            for(Show show : theater.getShows()){
                if(this.movieMap.containsKey(show.getMovie().getName())){
                    this.movieMap.get(show.getMovie().getName()).add(show);
                }else{
                     ArrayList<Show> showArrayList = new ArrayList<>();
                     showArrayList.add(show);
                     this.movieMap.put(show.getMovie().getName(),showArrayList);
                }
            }
        }
    }

    public ArrayList<Show> searchShow(String movie) throws Exception {
        if(this.movieMap.containsKey(movie)){
            return this.movieMap.get(movie);
        }

        throw new Exception("No show present");
    }
}
