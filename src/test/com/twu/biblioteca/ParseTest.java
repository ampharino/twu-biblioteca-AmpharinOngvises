package com.twu.biblioteca;

import com.twu.biblioteca.command.CommandParser;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ParseTest {

    @Test
    public void parseListType(){
        int cmd = CommandParser.parseCommand("list");
        assertEquals(CommandParser.LIST_ITEMS, cmd);

    }

    @Test
    public void parseInvalidCommandTest(){
        int command = CommandParser.parseCommand("invalidcommand");
        assertEquals(CommandParser.INVALID_COMMAND, command);
    }

    @Test
    public void parseArgsTest(){
        ByteArrayInputStream in  = new ByteArrayInputStream("checkout book The Iliad".getBytes());
        System.setIn(in);
        String [] cmdAndArgs = CommandParser.getCommandFromUser();
        assertEquals("checkout", cmdAndArgs[0]);
        assertEquals(3 ,cmdAndArgs.length);
        assertEquals("The Iliad", cmdAndArgs[2]);
        System.setIn(System.in);
    }

    @Test
    public void parseIncorrectArgs(){
        ByteArrayInputStream in  = new ByteArrayInputStream("checkout".getBytes());
        System.setIn(in);
        String [] cmdAndArgs = CommandParser.getCommandFromUser();
        assertEquals("checkout", cmdAndArgs[0]);
        assertEquals(3 ,cmdAndArgs.length);
        System.setIn(System.in);
    }

    @Test
    public void parseCheckOutMovie(){
        ByteArrayInputStream in = new ByteArrayInputStream("checkout movie Inception".getBytes());
        System.setIn(in);
        String [] cmdAndArgs = CommandParser.getCommandFromUser();
        assertEquals("checkout", cmdAndArgs[0]);
        assertEquals("movie", cmdAndArgs[1]);
        System.setIn(System.in);

    }
}
