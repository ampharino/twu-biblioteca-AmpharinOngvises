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

    @Override
    public LibraryItem checkOutItem(String title) {
        Movie movie = movies.get(title);
        if(!movieAvailable(movie)){
            System.out.println("Sorry, that movie is not available");
            return null;
        }
        else{
            System.out.println("Thank you! Enjoy the movie");
            movie.setAvailable(false);
            return movie;
        }
    }

    private boolean movieAvailable(Movie movie){
        return movie != null && movie.isAvailable();
    }

    @Override
    public boolean checkAvailability(String title){
        Movie movie = this.movies.get(title);
        return movieAvailable(movie);
    }

    @Override
    public void makeAvailable(String title){
        Movie selectedMovie = this.movies.get(title);
        selectedMovie.setAvailable(true);
        System.out.println("Thank you for returning the movie");
    }

    @Override
    public void addItem(LibraryItem item) {
        Movie movie = (Movie)item;
        this.movies.put(movie.getTitle(),movie);
    }
}
