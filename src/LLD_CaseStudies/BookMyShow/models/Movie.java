package LLD_CaseStudies.BookMyShow.models;

import LLD_CaseStudies.BookMyShow.Enums.Genre;
import LLD_CaseStudies.BookMyShow.Enums.Language;

public class Movie {
    private String name ;
    private float rating = 0.0f;
    private Language language;
    private Genre genre;

    public Movie(String name, Language language, Genre genre) {
        this.name = name;
        this.language = language;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Show{" +
                "name=" + name +
                ", language=" + language +
                ", genre=" + genre +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
