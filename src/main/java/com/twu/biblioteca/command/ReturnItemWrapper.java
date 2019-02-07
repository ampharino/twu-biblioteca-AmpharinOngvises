package com.twu.biblioteca.command;

import com.twu.biblioteca.BookList;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.ItemType;
import com.twu.biblioteca.LibraryCatalog;

public class ReturnItemWrapper {
    private Customer currentUser;
    private LibraryCatalog library;

    public ReturnItemWrapper(Customer user, LibraryCatalog library){
        this.currentUser = user;
        this.library = library;
    }

    public void execute(ItemType type, String title){
        if(!this.currentUser.hasItem(type, title)){
            String returnMsg = type == ItemType.INVALID ? "item" : String.valueOf(type).toLowerCase();
            System.out.printf("That is not a valid %s to return\n", returnMsg);
            return;
        }
        this.currentUser.removeItemFromCollection(type,title);
        this.library.makeItemAvailable(type, title);
    }

}
