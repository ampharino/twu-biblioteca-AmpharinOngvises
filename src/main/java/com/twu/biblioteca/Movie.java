package com.twu.biblioteca;

public class Movie extends LibraryItem{
    private String director;
    private double rating;
    private int releaseYear;

    public Movie(String title, String director, int releaseYear, double rating){
        super(title);
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getTitle() + " | " + this.director + " | " + this.releaseYear + " | " + this.rating);
    }
}
