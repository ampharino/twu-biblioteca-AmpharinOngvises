package com.twu.biblioteca;

public class ListBooksCommand implements Command {
    private final BookList bookList;

    public ListBooksCommand(BookList bookList){
        this.bookList = bookList;
    }

    public void execute(){
        bookList.printAllBooks();
    }



}
