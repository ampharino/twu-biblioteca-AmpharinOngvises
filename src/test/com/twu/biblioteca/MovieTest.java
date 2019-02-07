package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    public void printMovieInformation(){
        LibraryItem movie = new Movie("a", "director", 1, 10);
        movie.displayInfo();
        assertEquals("a | director | 1 | 10.0\n", outContent.toString());
    }

    @Test
    public void checkOutMovie(){
        ItemList movies = new MovieList(MovieList.defaultMovieList());
        LibraryItem movie = movies.checkOutItem("Inception");
        assertEquals("Inception", movie.getTitle());
        assertEquals(false, movie.isAvailable());
        assertEquals("Thank you! Enjoy the movie\n", outContent.toString());
    }

    @Test
    public void checkOutInvalidMovie(){
        ItemList movies = new MovieList(MovieList.defaultMovieList());
        LibraryItem movie = movies.checkOutItem("invalid");
        assertEquals(null,movie);
        assertEquals("Sorry, that movie is not available\n", outContent.toString());
    }



}
