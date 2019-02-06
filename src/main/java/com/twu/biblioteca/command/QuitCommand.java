package com.twu.biblioteca.command;

import com.twu.biblioteca.command.Command;

public class QuitCommand implements Command {
    public void execute(){
        System.out.println("Quitting Application...");
        System.exit(0);
    }
}
