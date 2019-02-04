package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
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
        CommandController controller = new CommandController();
        controller.execute(CommandController.LIST_ALL_BOOKS);
        assertEquals("The Iliad | Homer | 1998" + "\n" +
                        "The Winds of Winter | George R. R. Martin | 2050" + "\n" +
                        "Pet Sematary | Stephen King | 1983\n", outContent.toString());
    }

    @Test
    public void parseInvalidCommandTest(){
        CommandController controller = new CommandController();
        int command = controller.parseCommand("invalidcommand");
        assertEquals(CommandController.INVALID_COMMAND, command);

    }

    @Test
    public void executeInvalidCommand(){
        CommandController controller = new CommandController();
        controller.execute(CommandController.INVALID_COMMAND);
        assertEquals("Please enter a valid option\n", outContent.toString());
    }

}
