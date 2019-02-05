package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        Menu.getOptions();
        BookList bookList = new BookList(BookList.defaultBookList());
        Command listBooks = new ListBooksCommand(bookList);
        Command quit = new QuitCommand();
        Command invalid = new InvalidCommand();

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
                    bookList.checkOutBook(bookTitle);
                    break;
                default:
                    invalid.execute();
                    break;
            }
        }

    }
}
