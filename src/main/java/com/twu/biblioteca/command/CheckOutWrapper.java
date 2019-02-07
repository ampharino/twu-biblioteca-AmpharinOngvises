package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookList;
import com.twu.biblioteca.Customer;

public class CheckOutWrapper {
    private Customer currentUser;
    private BookList library;

    public CheckOutWrapper(Customer user, BookList bookList){
        this.currentUser = user;
        this.library = bookList;
    }

    public void execute(String title){
        Book checkedOutBook = library.checkOutItem(title);
        if(checkedOutBook == null){
            return;
        }
        currentUser.addBookToCollection(checkedOutBook);
    }
}
