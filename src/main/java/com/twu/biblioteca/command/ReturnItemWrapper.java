package com.twu.biblioteca.command;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.item.ItemType;
import com.twu.biblioteca.itemlist.LibraryCatalog;

public class ReturnItemWrapper {
    private User currentUser;
    private LibraryCatalog library;

    public ReturnItemWrapper(User user, LibraryCatalog library){
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
