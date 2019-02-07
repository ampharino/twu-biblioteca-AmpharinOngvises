package com.twu.biblioteca.command;

import java.util.Arrays;
import java.util.Scanner;


public class CommandParser {
    public static final int LIST_ALL_BOOKS = 0;
    public static final int INVALID_COMMAND = -1;
    public static final int EXIT = 1;
    public static final int CHECKOUT = 2;
    public static final int RETURN = 3;
    public static final int OPTIONS = 4;
    public static final int USER_BOOKS = 5;
    public static final int LIST_ITEMS = 6;



    public static String[] getCommandFromUser(){
        String [] cmdAndArgs = new String[3];
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a command");
        String input = reader.nextLine();
        String [] splitInput = input.split(" ", 3);
        for(int i=0; i<splitInput.length; i++){
            cmdAndArgs[i] = splitInput[i];
        }
        return cmdAndArgs;
    }

    public static int parseCommand(String cmd){
        switch(cmd){
            case "list":
                return LIST_ITEMS;
            case "quit":
                return EXIT;
            case "checkout":
                return CHECKOUT;
            case "return":
                return RETURN;
            case "options":
                return OPTIONS;
            case "mybooks":
                return USER_BOOKS;
            default:
                return INVALID_COMMAND;

        }
    }
}
