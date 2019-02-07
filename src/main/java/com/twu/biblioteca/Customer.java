package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<String,LibraryItem> checkedOutItems;

    public Customer(){
        this.checkedOutItems = new HashMap<>();
    }

    public void addItemToCollection(LibraryItem item){
        this.checkedOutItems.put(item.getTitle(),item);
    }

    public int getNumBooksCheckedOut(){
        return this.checkedOutItems.size();
    }

    public void removeBookFromCollection(String title){
        this.checkedOutItems.remove(title);
    }

    public boolean hasItem(String title){
        return this.checkedOutItems.containsKey(title);
    }

    public void listBooks(){
        this.checkedOutItems.forEach(
                (title,item)-> {
                    item.displayInfo();
                }
                );
    }

}
