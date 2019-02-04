package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu.printWelcomeMsg();
        Menu.getOptions();
        CommandController controller = new CommandController();
        while(true){
            String input = controller.getCommandFromUser();
            int command = controller.parseCommand(input);
            controller.execute(command);
        }

    }
}
