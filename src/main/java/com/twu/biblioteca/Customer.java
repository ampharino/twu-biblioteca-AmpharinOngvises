package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<String,Book> checkedOutBooks;

    public Customer(){
        this.checkedOutBooks = new HashMap<>();
    }

    public void addBookToCollection(Book book){
        this.checkedOutBooks.put(book.getTitle(),book);
    }

    public int getNumBooksCheckedOut(){
        return this.checkedOutBooks.size();
    }

    public void removeBookFromCollection(String title){
        this.checkedOutBooks.remove(title);
    }

    public boolean hasBook(String title){
        return this.checkedOutBooks.containsKey(title);
    }

    public void listBooks(){
        this.checkedOutBooks.forEach(
                (title,book)-> {
                    System.out.println(title + " | " + book.getAuthor() + " | " + book.getPublishYear());
                }
                );
    }

}
