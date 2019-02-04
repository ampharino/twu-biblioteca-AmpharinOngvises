package com.twu.biblioteca;

import java.io.PrintStream;

public class FakePrinter {
    private PrintStream printStream;

    public FakePrinter(PrintStream printStream){
        this.printStream = printStream;
    }

    public void print(String message){
        printStream.println(message);
    }
}
