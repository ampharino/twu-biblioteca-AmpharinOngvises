package com.twu.biblioteca.itemlist;

import com.twu.biblioteca.item.LibraryItem;

public interface ItemList {

    public void displayAvailableItems();

    public LibraryItem checkOutItem(String title);

    public boolean checkAvailability(String title);

    public void makeAvailable(String title);

    public void addItem(LibraryItem item);

}
