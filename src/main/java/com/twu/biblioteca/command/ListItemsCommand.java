package com.twu.biblioteca.command;

import com.twu.biblioteca.ItemList;

public class ListItemsCommand implements Command {
    private final ItemList itemList;

    public ListItemsCommand(ItemList itemList){
        this.itemList = itemList;
    }

    public void execute(){
        itemList.displayAvailableItems();
    }



}
