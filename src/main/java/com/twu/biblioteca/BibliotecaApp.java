package com.twu.biblioteca;

import com.twu.biblioteca.command.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        Menu.getOptions();
        BookList bookList = new BookList(BookList.defaultBookList());
        LibraryCatalog library = new LibraryCatalog();
        ListItemsWrapper listItems = new ListItemsWrapper(library);
        Command listBooks = new ListItemsCommand(bookList);
        Command quit = new QuitCommand();
        Command invalid = new InvalidCommand();
        Customer user = new Customer();
        CheckOutWrapper checkout = new CheckOutWrapper(user, bookList);
        ReturnBookWrapper returnBook = new ReturnBookWrapper(user, bookList);
        Command listUserBooks = new ListUserBooksCommand(user);

        while(true){
            String[] cmdAndArgs = CommandParser.getCommandFromUser();
            int command = CommandParser.parseCommand(cmdAndArgs[0]);
            String arg = cmdAndArgs[1];
            switch(command){
                case CommandParser.LIST_ITEMS:
                    ItemType type = ItemType.lookup(arg);
                    listItems.execute(type);
                    break;
                case CommandParser.EXIT:
                    quit.execute();
                    break;
                case CommandParser.CHECKOUT:
                    checkout.execute(arg);
                    break;
                case CommandParser.RETURN:
                    returnBook.execute(arg);
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
