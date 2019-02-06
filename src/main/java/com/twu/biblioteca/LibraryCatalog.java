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
}
