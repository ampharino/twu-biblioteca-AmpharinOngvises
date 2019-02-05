package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookTest {

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
    public void bookInfoTest(){
        Book testBook = new Book("Title", "Author", 2019);
        assertEquals("Title", testBook.getTitle());
        assertEquals("Author", testBook.getAuthor());
        assertEquals(2019, testBook.getPublishYear());
    }

    @Test
    public void addBookTest(){
        Book testBook = new Book("Book A", "Author A", 2018);
        BookList bookList = new BookList();
        assertEquals(0, bookList.getBooks().size());
        bookList.addBook(testBook);
        assertEquals(1,bookList.getBooks().size());

    }

    @Test
    public void viewBookListTest(){
        BookList bookList = new BookList();
        bookList.addBook(new Book("Book A", "Author A", 2018));
        bookList.addBook(new Book("Book B", "Author B", 2019));
        bookList.printAllBooks();
        assertEquals("Book A | Author A | 2018" + "\n"
                + "Book B | Author B | 2019\n" , outContent.toString());
    }

    @Test
    public void checkOutBook(){
        BookList bookList = new BookList(BookList.defaultBookList());
        bookList.checkOutBook("The Iliad");
        bookList.printAllBooks();
        assertEquals("The Winds of Winter | George R. R. Martin | 2050\n" +
                "Pet Sematary | Stephen King | 1983\n", outContent.toString());
    }
}
