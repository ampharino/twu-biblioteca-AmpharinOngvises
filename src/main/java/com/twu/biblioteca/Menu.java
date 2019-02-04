package com.twu.biblioteca;

public class Menu {
    private static final String options = "list\tList of Books";


    public static void printWelcomeMsg(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
    public static void getOptions(){
        System.out.println("Available Commands:");
        System.out.println(options);
    }
}
