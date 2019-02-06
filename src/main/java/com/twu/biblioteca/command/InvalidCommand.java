package com.twu.biblioteca.command;

import com.twu.biblioteca.command.Command;

public class InvalidCommand implements Command {
    public void execute(){
        System.out.println("Please enter a valid option");
    }
}
