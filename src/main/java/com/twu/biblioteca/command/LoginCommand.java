package com.twu.biblioteca.command;

import com.twu.biblioteca.Customer;

import java.util.Scanner;

public class LoginCommand{
    public Customer sessionUser;



    public static Customer execute(Customer user) {
        if(user != null){
            System.out.println("You are already logged in");
            return user;
        }
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your library number");
        String libraryNumber = reader.nextLine();
        System.out.println("Enter your password");
        String password = reader.nextLine();
        return Customer.login(libraryNumber, password);
    }
}
