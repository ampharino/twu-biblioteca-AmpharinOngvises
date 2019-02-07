package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTest {

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
    public void checkedOutBookInCollection(){
        BookList bookList = new BookList(BookList.defaultBookList());
        Book checkedOut = bookList.checkOutItem("The Iliad");
        Customer user = new Customer();
        assertEquals(0,user.getNumBooksCheckedOut());
        user.addItemToCollection(checkedOut);
        assertEquals(1,user.getNumBooksCheckedOut());
    }

    @Test
    public void removeBookFromCollection(){
        Book testBook = new Book("a", "author", 1);
        Customer user = new Customer();
        user.addItemToCollection(testBook);
        assertEquals(1,user.getNumBooksCheckedOut());
        user.removeBookFromCollection("a");
        assertEquals(0, user.getNumBooksCheckedOut());
    }

    @Test
    public void listUserBooks(){
        Book testBook = new Book("a","author",1);
        Customer user = new Customer();
        user.addItemToCollection(testBook);
        user.listBooks();
        assertEquals("a | author | 1\n", outContent.toString());
    }



}
