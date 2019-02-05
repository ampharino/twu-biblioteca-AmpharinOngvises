package com.twu.biblioteca;

public class Menu {
    private static final String[] options = {
            "list\tList of Books",
            "quit\tQuit Application",
            "checkout [title]\t Check out book with selected title",

    };


    public static void printWelcomeMsg(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
    public static void getOptions(){
        System.out.println("Available Commands:");
        for (String option:options) {
            System.out.println(option);
        }

    }
}
