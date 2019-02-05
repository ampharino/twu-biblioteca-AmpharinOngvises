package com.twu.biblioteca;

import java.util.Scanner;


public class CommandController {
    private Command listBooks;
    private Command quitApp;
    static final int LIST_ALL_BOOKS = 0;
    static final int INVALID_COMMAND = -1;
    static final int EXIT = 1;

    public CommandController(){
        this.listBooks = new ListBooksCommand(new BookList(BookList.defaultBookList()));
        this.quitApp = new QuitCommand();
    }
    public void execute(int command){
        switch(command){
            case LIST_ALL_BOOKS:
                listBooks.execute();
                break;
            case EXIT:
                quitApp.execute();
                break;
            default:
                System.out.println("Please enter a valid option");
        }
    }

    public String getCommandFromUser(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a command");
        return reader.next();
    }

    public int parseCommand(String input){
        switch(input){
            case "list":
                return LIST_ALL_BOOKS;
            case "quit":
                return EXIT;
            default:
                return INVALID_COMMAND;

        }
    }
}
