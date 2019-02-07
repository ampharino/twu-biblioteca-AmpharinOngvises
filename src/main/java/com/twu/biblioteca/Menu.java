package com.twu.biblioteca;

public class Menu {
    private static final String[] options = {
            "list [type]\tList available movies or books",
            "login\t Login",
            "checkout [type] [title]\t Check out book with selected title",
            "return [type] [title]\t Return book with selected title",
            "myinfo\t View my contact information",
            "myitems\t List all items that you have currently checked out",
            "options\t View Options",
            "quit\tQuit Application",

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
