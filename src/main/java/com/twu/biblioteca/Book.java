package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int publishYear;

    public Book(String title, String author, int publishYear){
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getPublishYear(){
        return this.publishYear;
    }

}
