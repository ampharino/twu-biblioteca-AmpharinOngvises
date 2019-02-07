package com.twu.biblioteca;

import com.twu.biblioteca.command.Command;
import com.twu.biblioteca.command.LoginCommand;
import org.junit.Test;


import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class LoginCommandTest {

    @Test
    public void login(){
        Customer sessionUser = null;
        ByteArrayInputStream in  = new ByteArrayInputStream(("123-4567"  + '\n' +
                "password1" + '\n').getBytes());
        System.setIn(in);
        LoginCommand login = new LoginCommand();
        sessionUser = login.execute(sessionUser);
        assertEquals("Adam", sessionUser.getName());
        System.setIn(System.in);
    }
}
