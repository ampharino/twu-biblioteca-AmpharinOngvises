package com.twu.biblioteca.command;

import com.twu.biblioteca.Customer;

public class ListUserBooksCommand implements Command {
    private Customer user;

    public ListUserBooksCommand(Customer user){
        this.user = user;
    }

    public void execute(){
        if(user.getNumItemsCheckedOut() == 0){
            System.out.println("You have not checked out any books");
            return;
        }
        user.listBooks();
    }
}
