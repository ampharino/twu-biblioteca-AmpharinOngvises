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
        CheckOutWrapper checkout = new CheckOutWrapper(user, library);
        ReturnBookWrapper returnBook = new ReturnBookWrapper(user, bookList);
        Command listUserBooks = new ListUserBooksCommand(user);

        while(true){
            String[] cmdAndArgs = CommandParser.getCommandFromUser();
            int command = CommandParser.parseCommand(cmdAndArgs[0]);
            String title;
            ItemType type;
            switch(command){
                case CommandParser.LIST_ITEMS:
                    type = ItemType.lookup(cmdAndArgs[1]);
                    listItems.execute(type);
                    break;
                case CommandParser.EXIT:
                    quit.execute();
                    break;
                case CommandParser.CHECKOUT:
                    type = ItemType.lookup(cmdAndArgs[1]);
                    title = cmdAndArgs[2];
                    checkout.execute(type, title);
                    break;
                case CommandParser.RETURN:
                    returnBook.execute(cmdAndArgs[1]);
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
