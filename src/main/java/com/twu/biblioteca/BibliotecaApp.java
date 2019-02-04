package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        MessagePrinter messagePrinter = new MessagePrinter(System.out);
        messagePrinter.printWelcomeMsg();
        BookList bookList = new BookList(BookList.defaultBookList());
        messagePrinter.printAllBooks(bookList);

    }
}
