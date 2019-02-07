package com.twu.biblioteca;

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
                return null;
        }
    }
}
