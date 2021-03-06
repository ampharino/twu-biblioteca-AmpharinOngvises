package com.twu.biblioteca.itemlist;

import com.twu.biblioteca.item.LibraryItem;
import com.twu.biblioteca.item.ItemType;

public class LibraryCatalog {
    private ItemList bookList;
    private ItemList movieList;

    public LibraryCatalog(){
        bookList = new BookList(BookList.defaultBookList());
        movieList = new MovieList(MovieList.defaultMovieList());
    }

    public ItemList getBookList() {
        return bookList;
    }

    public ItemList getMovieList() {
        return movieList;
    }

    public LibraryItem checkOut(ItemType type, String title){
        switch (type){
            case MOVIE:
                return this.movieList.checkOutItem(title);
            case BOOK:
                return this.bookList.checkOutItem(title);
            default:
                System.out.println("Sorry, that item is not available");
                return null;
        }
    }

    public void makeItemAvailable(ItemType type, String title){
        switch(type){
            case MOVIE:
                this.movieList.makeAvailable(title);
                break;
            case BOOK:
                this.bookList.makeAvailable(title);
                break;
            default:
                System.out.println("Huh?");

        }
    }
}
