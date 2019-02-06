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

public class CommandTest {

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
        Command listBook = new ListBooksCommand(new BookList(BookList.defaultBookList()));
        listBook.execute();
        String lines = outContent.toString();
        assertEquals(3, lines.length()-lines.replace("\n","").length());
    }


    @Test
    public void parseArgsTest(){
        ByteArrayInputStream in  = new ByteArrayInputStream("checkout The Iliad".getBytes());
        System.setIn(in);
        String [] cmdAndArgs = CommandParser.getCommandFromUser();
        assertEquals("checkout", cmdAndArgs[0]);
        assertEquals(2,cmdAndArgs.length);
        assertEquals("The Iliad", cmdAndArgs[1]);
        System.setIn(System.in);
    }
    @Test
    public void parseInvalidCommandTest(){
        int command = CommandParser.parseCommand("invalidcommand");
        assertEquals(CommandParser.INVALID_COMMAND, command);
    }

    @Test
    public void executeInvalidCommand(){
        Command invalidCommand = new InvalidCommand();
        invalidCommand.execute();
        assertEquals("Please enter a valid option\n", outContent.toString());
    }

    @Test
    public void returnBookCommand(){
        BookList bookList = new BookList();
        Customer user = new Customer();
        Book testBook = new Book("A", "author", 11);
        testBook.setAvailable(false);
        bookList.addBook(testBook);
        user.addBookToCollection(testBook);
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

    @Test
    public void checkOutCommand(){
        BookList bookList = new BookList(BookList.defaultBookList());
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user,bookList);
        checkout.execute("The Iliad");
        assertEquals(true, user.hasBook("The Iliad"));
        assertEquals(false, bookList.checkBookAvailability("The Iliad"));
    }

    @Test
    public void  checkOutInvalid(){
        BookList bookList = new BookList();
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user,bookList);
        checkout.execute("invalidbook");
        assertEquals(false, user.hasBook("invalidbook"));
        assertEquals("Sorry, that book is not available\n", outContent.toString());
    }

    @Test
    public void listUserBooks(){
        Customer user = new Customer();
        Command listUserBooks = new ListUserBooksCommand(user);
        Book book = new Book("a", "author", 1);
        user.addBookToCollection(book);
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

}
