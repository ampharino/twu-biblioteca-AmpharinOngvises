package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class BookList extends ItemList {
     private Map<String,Book> books;

     public BookList(Map<String, Book> books){
         this.books = books;
     }

     public BookList(){
         this.books = new HashMap<>();
     }

     public static Map<String,Book> defaultBookList(){
         Map<String,Book> books = new HashMap<>();
         books.put("The Iliad",new Book("The Iliad", "Homer", 1998));
         books.put("The Winds of Winter", new Book("The Winds of Winter",
                 "George R. R. Martin", 2050 ));
         books.put("Pet Sematary", new Book("Pet Sematary", "Stephen King", 1983));
         return books;
     }

     public void addBook(Book newBook){
         this.books.put(newBook.getTitle(),newBook);
     }

     public Map<String,Book> getBooks(){
         return this.books;
     }

     public Book checkOutBook(String title){
         Book selectedBook = this.books.get(title);
         if(!checkBookAvailability(title)){
             System.out.println("Sorry, that book is not available");
             return null;
         }
         else{
             selectedBook.setAvailable(false);
             System.out.println("Thank you! Enjoy the book");
             return selectedBook;

         }
     }

     public boolean checkBookAvailability(String title){
         Book selectedBook = this.books.get(title);
         if(selectedBook == null || !selectedBook.isAvailable()){
             return false;
         }
         return true;
     }

     public void makeBookAvailable(String title){
         Book selectedBook = this.books.get(title);
         selectedBook.setAvailable(true);
         System.out.println("Thank you for returning the book");
     }

     @Override
    public void displayAvailableItems(){
        this.books.forEach(
                (title,book) -> {
                    if(book.isAvailable()){
                        book.displayInfo();
                    }
                });
    }






}
