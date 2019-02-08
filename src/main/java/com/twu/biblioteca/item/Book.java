package com.twu.biblioteca.item;

public class Book extends LibraryItem{
    private String author;
    private int publishYear;
    private boolean isAvailable;

    public Book(String title, String author, int publishYear){
        super(title);
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getPublishYear(){
        return this.publishYear;
    }


    @Override
    public void displayInfo() {
        System.out.println(this.getTitle() + " | " + this.getAuthor() + " | " + this.getPublishYear());
    }
}
