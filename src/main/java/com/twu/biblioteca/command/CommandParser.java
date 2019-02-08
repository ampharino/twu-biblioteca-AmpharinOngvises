package com.twu.biblioteca.command;

import java.util.Scanner;


public class CommandParser {



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

    public static CommandType parseCommand(String cmd){
        switch(cmd){
            case "list":
                return CommandType.LIST_ITEMS;
            case "quit":
                return CommandType.EXIT;
            case "checkout":
                return CommandType.CHECKOUT;
            case "return":
                return CommandType.RETURN;
            case "options":
                return CommandType.OPTIONS;
            case "myitems":
                return CommandType.USER_ITEMS;
            case "login":
                return CommandType.LOGIN;
            case "myinfo":
                return CommandType.CONTACT_INFO;
            default:
                return CommandType.INVALID_COMMAND;

        }
    }
}
