package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CommandTest {

    @Test
    public void listBookCommandTest(){
        PrintStream printStream = mock(PrintStream.class);
        BookList bookList = new BookList(BookList.defaultBookList());
        Command listBooks = new listBooksCommand(bookList);
        CommandController controller = new CommandController();
        controller.execute(listBooks);
        ArgumentCaptor<String> arguement = ArgumentCaptor.forClass(String.class);
        verify(printStream, times(3)).println(arguement.capture());
        assertEquals("The Iliad | Homer | 1998", arguement.getAllValues().get(0));
        assertEquals("The Winds of Winter | George R. R. Martin | 2050", arguement.getAllValues().get(1));
        assertEquals("Pet Sematary | Stephen King | 1983", arguement.getAllValues().get(2));

    }

}
