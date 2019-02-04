package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        BookList bookList = new BookList(BookList.defaultBookList());
        Menu.getOptions();
        CommandController controller = new CommandController();
        Command listBooks = new listBooksCommand(bookList);
        while(true){

        }

    }
}
