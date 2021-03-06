package com.twu.biblioteca.command;

import com.twu.biblioteca.user.User;

public class ListUserBooksCommand implements Command {
    private User user;

    public ListUserBooksCommand(User user){
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
