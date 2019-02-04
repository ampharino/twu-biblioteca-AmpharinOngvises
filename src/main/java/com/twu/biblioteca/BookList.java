package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {
     private List<Book> books;

     public BookList(List<Book> books){
         this.books = books;
     }

     public BookList(){
         this.books = new ArrayList<Book>();
     }

     public static List<Book> defaultBookList(){
         List<Book> books = new ArrayList<Book>();
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

    public void printAllBooks(){
        for(Book currentBook : this.books){
            System.out.println(currentBook.getTitle() + " | "
                    + currentBook.getAuthor() + " | " + currentBook.getPublishYear());
        }
    }




}
