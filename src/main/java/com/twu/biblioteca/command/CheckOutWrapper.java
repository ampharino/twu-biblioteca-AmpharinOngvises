package com.twu.biblioteca.command;

import com.twu.biblioteca.item.ItemType;
import com.twu.biblioteca.item.LibraryItem;
import com.twu.biblioteca.itemlist.LibraryCatalog;
import com.twu.biblioteca.user.User;

public class CheckOutWrapper {
    private User currentUser;
    private LibraryCatalog library;

    public CheckOutWrapper(User user, LibraryCatalog catalog){
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
