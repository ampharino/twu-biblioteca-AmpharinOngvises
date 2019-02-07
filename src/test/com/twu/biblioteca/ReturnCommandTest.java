package com.twu.biblioteca;

import com.twu.biblioteca.command.ReturnBookWrapper;
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
        BookList bookList = new BookList();
        Customer user = new Customer();
        Book testBook = new Book("A", "author", 11);
        testBook.setAvailable(false);
        bookList.addBook(testBook);
        user.addItemToCollection(testBook);
        ReturnBookWrapper returnBook = new ReturnBookWrapper(user,bookList);
        returnBook.execute("A");
        assertEquals(true,testBook.isAvailable());
        assertEquals(0,user.getNumBooksCheckedOut());
    }

    @Test
    public void returnInvalidBook(){
        BookList bookList = new BookList(BookList.defaultBookList());
        Customer user = new Customer();
        ReturnBookWrapper returnBook = new ReturnBookWrapper(user, bookList);
        returnBook.execute("The Iliad");
        assertEquals("That is not a valid book to return\n", outContent.toString());
    }
}
