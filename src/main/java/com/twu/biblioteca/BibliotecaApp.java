package com.twu.biblioteca;

import com.twu.biblioteca.item.ItemType;
import com.twu.biblioteca.itemlist.LibraryCatalog;
import com.twu.biblioteca.command.*;
import com.twu.biblioteca.user.User;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        Menu.getOptions();
        LibraryCatalog library = new LibraryCatalog();
        ListItemsWrapper listItems = new ListItemsWrapper(library);
        Command quit = new QuitCommand();
        Command invalid = new InvalidCommand();
        User user = null;
        CheckOutWrapper checkout = null;
        ReturnItemWrapper returnItem = null;
        Command listUserItems = null;

        while(true){
            String[] cmdAndArgs = CommandParser.getCommandFromUser();
            CommandType command = CommandParser.parseCommand(cmdAndArgs[0]);
            String title = cmdAndArgs[2];
            ItemType type = ItemType.lookup(cmdAndArgs[1]);
            switch(command){
                case LIST_ITEMS:
                    listItems.execute(type);
                    break;
                case EXIT:
                    quit.execute();
                    break;
                case CHECKOUT:
                    if(user == null){
                        System.out.println("Please login to checkout items");
                        break;
                    }
                    checkout.execute(type, title);
                    break;
                case RETURN:
                    if(user == null){
                        System.out.println("Please login to return items");
                        break;
                    }
                    returnItem.execute(type, title);
                    break;
                case OPTIONS:
                    Menu.getOptions();
                    break;
                case USER_ITEMS:
                    if(user == null){
                        System.out.println("Please login to view your checked out items");
                        break;
                    }
                    listUserItems.execute();
                    break;
                case LOGIN:
                    user = LoginCommand.execute(user);
                    checkout = new CheckOutWrapper(user, library);
                    returnItem = new ReturnItemWrapper(user, library);
                    listUserItems = new ListUserBooksCommand(user);
                    break;

                case CONTACT_INFO:
                    if(user == null){
                        System.out.println("Please login");
                        break;
                    }
                    user.viewInfo();
                    break;
                default:
                    invalid.execute();
                    break;
            }
        }

    }
}
