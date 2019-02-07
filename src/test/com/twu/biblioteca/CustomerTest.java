package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

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
        assertEquals(0,user.getNumItemsCheckedOut());
        user.addItemToCollection(ItemType.BOOK,checkedOut);
        assertEquals(1,user.getNumItemsCheckedOut());
    }

    @Test
    public void removeBookFromCollection(){
        Book testBook = new Book("a", "author", 1);
        Customer user = new Customer();
        user.addItemToCollection(ItemType.BOOK,testBook);
        assertEquals(1,user.getNumItemsCheckedOut());
        user.removeItemFromCollection(ItemType.BOOK,"a");
        assertEquals(0, user.getNumItemsCheckedOut());
    }

    @Test
    public void addMovieToCollection(){
        Customer user = new Customer();
        Book book = new Book("IT", "Stephen King", 1990);
        user.addItemToCollection(ItemType.BOOK,book);
        assertEquals(false,user.hasItem(ItemType.MOVIE, "IT"));
        assertEquals(true, user.hasItem(ItemType.BOOK,"IT"));
    }

    @Test
    public void listUserBooks(){
        Book testBook = new Book("a","author",1);
        Customer user = new Customer();
        user.addItemToCollection(ItemType.BOOK, testBook);
        user.listBooks();
        assertEquals("a | author | 1\n", outContent.toString());
    }

    @Test
    public void userLookup(){
        PredefinedUsers user = PredefinedUsers.lookup("123-4567");
        assertEquals(PredefinedUsers.USER1,user);
    }

    @Test
    public void login(){
        Customer currentUser = Customer.login("123-4567", "password1");
        assertEquals("Adam", currentUser.getName());
    }

    @Test
    public void loginFail(){
        Customer currentUser = Customer.login("123-4567", "adsf");
        assertEquals("Incorrect password\n", outContent.toString());
    }





}
