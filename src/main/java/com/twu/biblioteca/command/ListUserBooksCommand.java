package com.twu.biblioteca.command;

import com.twu.biblioteca.Customer;
import com.twu.biblioteca.command.Command;

public class ListUserBooksCommand implements Command {
    private Customer user;

    public ListUserBooksCommand(Customer user){
        this.user = user;
    }

    public void execute(){
        if(user.getNumBooksCheckedOut() == 0){
            System.out.println("You have not checked out any books");
            return;
        }
        user.listBooks();
    }
}
