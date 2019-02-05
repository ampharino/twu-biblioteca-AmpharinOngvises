package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookList {
     private List<Book> books;

     public BookList(List<Book> books){
         this.books = books;
     }

     public BookList(){
         this.books = new ArrayList<>();
     }

     public static List<Book> defaultBookList(){
         List<Book> books = new ArrayList<>();
         books.add(new Book("The Iliad", "Homer", 1998));
         books.add(new Book("The Winds of Winter",
                 "George R. R. Martin", 2050 ));
         books.add(new Book("Pet Sematary", "Stephen King", 1983));
         return books;
     }

     public void addBook(Book newBook){
         this.books.add(newBook);
     }

     public List<Book> getBooks(){
         return this.books;
     }

     public void checkOutBook(String title){
         for(Book currentBook : this.books){
             if(currentBook.getTitle().equals(title) && currentBook.isAvailable()){
                 currentBook.setAvailable(false);
                 System.out.println("Thank you! Enjoy the book");
                 return;
             }
             else if(currentBook.getTitle().equals(title)){
                 System.out.println("Sorry, that book is not available");
                 return;
             }
         }
         System.out.println("Sorry, that book is not available");
     }

    public void printAllBooks(){
        for(Book currentBook : this.books){
            if(currentBook.isAvailable()){
                System.out.println(currentBook.getTitle() + " | "
                        + currentBook.getAuthor() + " | " + currentBook.getPublishYear());
            }
        }
    }






}
