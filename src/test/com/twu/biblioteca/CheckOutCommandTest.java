package com.twu.biblioteca;

import com.twu.biblioteca.command.CheckOutWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckOutCommandTest {

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
    public void  checkOutInvalid(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user,library);
        checkout.execute(ItemType.BOOK, "invalidbook");
        assertEquals(false, user.hasItem("invalidbook"));
        assertEquals("Sorry, that book is not available\n", outContent.toString());
    }

    @Test
    public void checkOutBookCommand(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user,library);
        checkout.execute(ItemType.BOOK,"The Iliad");
        assertEquals(true, user.hasItem("The Iliad"));
        assertEquals(false, library.getBookList().checkAvailability("The Iliad"));
    }

    @Test
    public void checkOutMovieCommand(){
        LibraryCatalog library = new LibraryCatalog();
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user, library);
        checkout.execute(ItemType.MOVIE, "Inception");
        assertEquals(true, user.hasItem("Inception"));
        assertEquals(false,library.getMovieList().checkAvailability("Inception"));
    }

}
