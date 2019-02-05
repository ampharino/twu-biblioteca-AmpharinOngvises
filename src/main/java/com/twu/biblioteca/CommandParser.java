package com.twu.biblioteca;

import java.util.Scanner;


public class CommandParser {
    static final int LIST_ALL_BOOKS = 0;
    static final int INVALID_COMMAND = -1;
    static final int EXIT = 1;
    static final int CHECKOUT = 2;
    static final int RETURN = 3;


    public static String[] getCommandFromUser(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a command");
        String input = reader.nextLine();
        return input.split(" ", 2);
    }

    public static int parseCommand(String cmd){
        switch(cmd){
            case "list":
                return LIST_ALL_BOOKS;
            case "quit":
                return EXIT;
            case "checkout":
                return CHECKOUT;
            default:
                return INVALID_COMMAND;

        }
    }
}
