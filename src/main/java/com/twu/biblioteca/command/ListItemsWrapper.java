package com.twu.biblioteca.command;

import com.twu.biblioteca.item.ItemType;
import com.twu.biblioteca.itemlist.LibraryCatalog;

public class ListItemsWrapper {
    private LibraryCatalog library;
    private Command listBooks;
    private Command listMovies;

    public ListItemsWrapper(LibraryCatalog lib){
        this.library = lib;
        this.listBooks = new ListItemsCommand(library.getBookList());
        this.listMovies = new ListItemsCommand(library.getMovieList());
    }

    public void execute(ItemType type){
        switch(type){
            case BOOK:
                listBooks.execute();
                break;
            case MOVIE:
                listMovies.execute();
                break;
            default:
                System.out.println("Sorry, those items are not available");
        }
    }

}
