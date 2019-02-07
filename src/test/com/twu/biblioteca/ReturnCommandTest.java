package com.twu.biblioteca;

import com.twu.biblioteca.command.ReturnItemWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ReturnCommandTest {
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
    public void returnBookCommand(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        Book testBook = new Book("A", "author", 11);
        testBook.setAvailable(false);
        library.getBookList().addItem(testBook);
        user.addItemToCollection(ItemType.BOOK,testBook);
        ReturnItemWrapper returnBook = new ReturnItemWrapper(user,library);
        returnBook.execute(ItemType.BOOK,"A");
        assertEquals(true,testBook.isAvailable());
        assertEquals(0,user.getNumItemsCheckedOut());
    }

    @Test
    public void returnInvalidBook(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        ReturnItemWrapper returnBook = new ReturnItemWrapper(user, library);
        returnBook.execute(ItemType.BOOK, "Inception");
        assertEquals("That is not a valid book to return\n", outContent.toString());
    }

    @Test
    public void returnInvalidMovie(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        ReturnItemWrapper returnItem = new ReturnItemWrapper(user, library);
        returnItem.execute(ItemType.MOVIE,"invalid");
        assertEquals("That is not a valid movie to return\n", outContent.toString());
    }

    @Test
    public void returnMovie(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        Movie movie = new Movie("A", "director", 11,10);
        movie.setAvailable(false);
        library.getMovieList().addItem(movie);
        user.addItemToCollection(ItemType.MOVIE,movie);
        ReturnItemWrapper returnMovie = new ReturnItemWrapper(user,library);
        returnMovie.execute(ItemType.MOVIE,"A");
        assertEquals(true,movie.isAvailable());
        assertEquals(0,user.getNumItemsCheckedOut());
    }

    @Test
    public void returnInvalidType(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        ReturnItemWrapper returnItem = new ReturnItemWrapper(user, library);
        returnItem.execute(ItemType.INVALID, "A");
        assertEquals("That is not a valid item to return\n", outContent.toString());
    }
}
