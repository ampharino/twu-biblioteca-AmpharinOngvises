package com.twu.biblioteca;

import com.twu.biblioteca.command.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        Menu.getOptions();
        LibraryCatalog library = new LibraryCatalog();
        ListItemsWrapper listItems = new ListItemsWrapper(library);
        Command quit = new QuitCommand();
        Command invalid = new InvalidCommand();
        Customer user = null;
        CheckOutWrapper checkout = null;
        ReturnItemWrapper returnItem = null;
        Command listUserItems = null;

        while(true){
            String[] cmdAndArgs = CommandParser.getCommandFromUser();
            int command = CommandParser.parseCommand(cmdAndArgs[0]);
            String title = cmdAndArgs[2];
            ItemType type = ItemType.lookup(cmdAndArgs[1]);
            switch(command){
                case CommandParser.LIST_ITEMS:
                    listItems.execute(type);
                    break;
                case CommandParser.EXIT:
                    quit.execute();
                    break;
                case CommandParser.CHECKOUT:
                    if(user == null){
                        System.out.println("Please login to checkout items");
                        break;
                    }
                    checkout.execute(type, title);
                    break;
                case CommandParser.RETURN:
                    if(user == null){
                        System.out.println("Please login to return items");
                        break;
                    }
                    returnItem.execute(type, title);
                    break;
                case CommandParser.OPTIONS:
                    Menu.getOptions();
                    break;
                case CommandParser.USER_ITEMS:
                    if(user == null){
                        System.out.println("Please login to view your checked out items");
                        break;
                    }
                    listUserItems.execute();
                    break;
                case CommandParser.LOGIN:
                    user = LoginCommand.execute(user);
                    checkout = new CheckOutWrapper(user, library);
                    returnItem = new ReturnItemWrapper(user, library);
                    listUserItems = new ListUserBooksCommand(user);
                    break;

                case CommandParser.CONTACT_INFO:
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
