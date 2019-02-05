package com.twu.biblioteca;

public class QuitCommand implements Command{
    public void execute(){
        System.out.println("Quitting Application...");
        System.exit(0);
    }
}
