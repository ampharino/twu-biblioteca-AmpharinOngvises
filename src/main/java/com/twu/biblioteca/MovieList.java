package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MovieList extends ItemList{

    private Map<String, Movie> movies;

    public MovieList(){
        this.movies = new HashMap<>();
    }

    public MovieList(Map<String, Movie> movies){
        this.movies = movies;
    }


    public static Map<String, Movie> defaultMovieList(){
        Map<String, Movie> movies = new HashMap<>();
        movies.put("Inception", new Movie("Inception", "Christopher Nolan", 2008, 10));
        movies.put("Avengers:Infinity War",
                new Movie("Avengers:Infinity War","Anthony Russo & Joe Russo", 2018, 8));
        movies.put("Your Name.", new Movie("Your Name.", "Makoto Shinkai", 2016, 9));
        movies.put("Fitzcarraldo", new Movie("Fitzcarraldo", "Werner Herzog", 1982, 8));
        movies.put("Groundhog Day", new Movie("Groundhog Day", "Harold Ramis", 1993, 7));
        return movies;
    }

    @Override
    public void displayAvailableItems(){
        this.movies.forEach(
                (title,movie) -> {
                    if(movie.isAvailable()){
                        movie.displayInfo();
                    }
                });
    }
}
