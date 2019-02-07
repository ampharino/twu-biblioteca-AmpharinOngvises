package com.twu.biblioteca;

import com.twu.biblioteca.command.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListCommandTest {

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
    public void listBookCommandTest(){
        Command listBook = new ListItemsCommand(new BookList(BookList.defaultBookList()));
        listBook.execute();
        String lines = outContent.toString();
        assertEquals(3, lines.length()-lines.replace("\n","").length());
    }


    @Test
    public void executeInvalidCommand(){
        Command invalidCommand = new InvalidCommand();
        invalidCommand.execute();
        assertEquals("Please enter a valid option\n", outContent.toString());
    }


    @Test
    public void listUserBooks(){
        Customer user = new Customer();
        Command listUserBooks = new ListUserBooksCommand(user);
        Book book = new Book("a", "author", 1);
        user.addItemToCollection(ItemType.BOOK,book);
        listUserBooks.execute();
        assertEquals("a | author | 1\n", outContent.toString());
    }

    @Test
    public void userHasNoCheckedOutBooks(){
        Customer user = new Customer();
        Command listUserBooks = new ListUserBooksCommand(user);
        listUserBooks.execute();
        assertEquals("You have not checked out any books\n", outContent.toString());
    }

    @Test
    public void listBookType(){
        LibraryCatalog library = new LibraryCatalog();
        ListItemsWrapper listItem = new ListItemsWrapper(library);
        listItem.execute(ItemType.BOOK);
        String lines = outContent.toString();
        assertEquals(3, lines.length()-lines.replace("\n","").length());
    }

    @Test
    public void listMovieType(){
        LibraryCatalog library = new LibraryCatalog();
        ListItemsWrapper listItem = new ListItemsWrapper(library);
        listItem.execute(ItemType.MOVIE);
        String lines = outContent.toString();
        assertEquals(5, lines.length()-lines.replace("\n","").length());
    }








}
