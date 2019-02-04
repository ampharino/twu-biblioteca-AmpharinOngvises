package com.twu.biblioteca;

import java.io.PrintStream;

public class MessagePrinter {

    private PrintStream printStream;

    public MessagePrinter(PrintStream printStream){
        this.printStream = printStream;
    }

    public void printWelcomeMsg(){
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void printAllBooks(BookList bookList){
        for(Book currentBook : bookList.getBooks()){
            printStream.println(currentBook.getTitle() + " | "
                    + currentBook.getAuthor() + " | " + currentBook.getPublishYear());
        }
    }
}
