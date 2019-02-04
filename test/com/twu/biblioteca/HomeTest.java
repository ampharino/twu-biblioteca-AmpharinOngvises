package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeTest {

    @Test
    public void welcomeMessageTest(){
        PrintStream printStream = mock(PrintStream.class);
        MessagePrinter messagePrinter = new MessagePrinter(printStream);
        messagePrinter.printWelcomeMsg();
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

}
