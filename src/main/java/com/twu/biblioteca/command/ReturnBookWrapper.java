package com.twu.biblioteca.command;

import com.twu.biblioteca.BookList;
import com.twu.biblioteca.Customer;

public class ReturnBookWrapper {
    private Customer currentUser;
    private BookList library;

    public ReturnBookWrapper(Customer user, BookList bookList){
        this.currentUser = user;
        this.library = bookList;
    }

    public void execute(String title){
        if(!this.currentUser.hasItem(title)){
            System.out.println("That is not a valid book to return");
            return;
        }
        this.currentUser.removeBookFromCollection(title);
        this.library.makeBookAvailable(title);
    }

}
