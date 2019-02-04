package com.twu.biblioteca;

public class listBooksCommand implements Command {
    private final BookList bookList;

    public listBooksCommand(BookList bookList){
        this.bookList = bookList;
    }

    public void execute(){
        bookList.printAllBooks();
    }



}
