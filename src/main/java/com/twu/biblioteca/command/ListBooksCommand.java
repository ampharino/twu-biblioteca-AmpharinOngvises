package com.twu.biblioteca.command;

import com.twu.biblioteca.BookList;
import com.twu.biblioteca.command.Command;

public class ListBooksCommand implements Command {
    private final BookList bookList;

    public ListBooksCommand(BookList bookList){
        this.bookList = bookList;
    }

    public void execute(){
        bookList.printAllBooks();
    }



}
