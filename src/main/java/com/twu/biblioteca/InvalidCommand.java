package com.twu.biblioteca;

public class InvalidCommand implements Command {
    public void execute(){
        System.out.println("Please enter a valid option");
    }
}
