package com.twu.biblioteca;

import java.util.Scanner;


public class CommandController {
    private Command listBooks;
    static final int LIST_ALL_BOOKS = 0;
    static final int INVALID_COMMAND = -1;

    public CommandController(){
        this.listBooks = new listBooksCommand(new BookList(BookList.defaultBookList()));
    }
    public void execute(int command){
        switch(command){
            case LIST_ALL_BOOKS:
                listBooks.execute();
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
            default:
                return INVALID_COMMAND;

        }
    }
}
