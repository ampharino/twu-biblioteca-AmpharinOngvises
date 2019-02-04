package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        BookList bookList = new BookList(BookList.defaultBookList());
        bookList.printAllBooks();

    }
}
