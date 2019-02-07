package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<String,LibraryItem> checkedOutItems;

    public Customer(){
        this.checkedOutItems = new HashMap<>();
    }

    public void addItemToCollection(ItemType type, LibraryItem item){
        this.checkedOutItems.put(this.getKey(type,item.getTitle()),item);
    }

    public int getNumBooksCheckedOut(){
        return this.checkedOutItems.size();
    }

    public void removeItemFromCollection(ItemType type, String title){
        this.checkedOutItems.remove(this.getKey(type,title));
    }

    public boolean hasItem(ItemType type, String title){
        return this.checkedOutItems.containsKey(this.getKey(type,title));
    }

    private String getKey(ItemType type, String title){
        return String.valueOf(type)+title;
    }

    public void listBooks(){
        this.checkedOutItems.forEach(
                (title,item)-> {
                    item.displayInfo();
                }
                );
    }

}
