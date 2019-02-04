package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookTest {

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
        PrintStream printStream = mock(PrintStream.class);
        MessagePrinter messagePrinter = new MessagePrinter(printStream);
        BookList bookList = new BookList();
        bookList.addBook(new Book("Book A", "Author A", 2018));
        bookList.addBook(new Book("Book B", "Author B", 2019));
        messagePrinter.printAllBooks(bookList);
        ArgumentCaptor<String> arguement = ArgumentCaptor.forClass(String.class);
        verify(printStream, times(2)).println(arguement.capture());
        assertEquals("Book A | Author A | 2018", arguement.getAllValues().get(0));
        assertEquals("Book B | Author B | 2019", arguement.getAllValues().get(1));



    }
}
