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
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user, library);
        ReturnItemWrapper returnItem = new ReturnItemWrapper(user, library);
        Command listUserBooks = new ListUserBooksCommand(user);

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
                    checkout.execute(type, title);
                    break;
                case CommandParser.RETURN:
                    returnItem.execute(type, title);
                    break;
                case CommandParser.OPTIONS:
                    Menu.getOptions();
                    break;
                case CommandParser.USER_BOOKS:
                    listUserBooks.execute();
                    break;
                default:
                    invalid.execute();
                    break;
            }
        }

    }
}
