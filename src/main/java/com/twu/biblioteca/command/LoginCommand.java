package com.twu.biblioteca.command;

import com.twu.biblioteca.user.User;

import java.util.Scanner;

public class LoginCommand{
    public User sessionUser;



    public static User execute(User user) {
        if(user != null){
            System.out.println("You are already logged in");
            return user;
        }
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your library number");
        String libraryNumber = reader.nextLine();
        System.out.println("Enter your password");
        String password = reader.nextLine();
        return User.login(libraryNumber, password);
    }
}
