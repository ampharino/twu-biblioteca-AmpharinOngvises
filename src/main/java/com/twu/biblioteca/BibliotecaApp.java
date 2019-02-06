package com.twu.biblioteca;

import com.twu.biblioteca.command.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        Menu.getOptions();
        BookList bookList = new BookList(BookList.defaultBookList());
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
            switch(command){
                case CommandParser.LIST_ALL_BOOKS:
                    listBooks.execute();
                    break;
                case CommandParser.EXIT:
                    quit.execute();
                    break;
                case CommandParser.CHECKOUT:
                    String bookTitle = cmdAndArgs[1];
                    checkout.execute(bookTitle);
                    break;
                case CommandParser.RETURN:
                    bookTitle = cmdAndArgs[1];
                    returnBook.execute(bookTitle);
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
