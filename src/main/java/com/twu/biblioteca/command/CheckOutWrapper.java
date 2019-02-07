package com.twu.biblioteca.command;

import com.twu.biblioteca.*;

public class CheckOutWrapper {
    private Customer currentUser;
    private LibraryCatalog library;

    public CheckOutWrapper(Customer user, LibraryCatalog catalog){
        this.currentUser = user;
        this.library = catalog;
    }

    public void execute(ItemType type, String title){
        LibraryItem checkedOutItem = library.checkOut(type, title);
        if(checkedOutItem == null){
            return;
        }
        currentUser.addItemToCollection(type, checkedOutItem);
    }
}
