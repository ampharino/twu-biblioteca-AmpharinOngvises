package com.twu.biblioteca;

import java.util.Map;

public abstract class ItemList {

    public abstract void displayAvailableItems();

    public abstract LibraryItem checkOutItem(String title);

    public abstract boolean checkAvailability(String title);

    public abstract void makeAvailable(String title);

    public abstract void addItem(LibraryItem item);

}
