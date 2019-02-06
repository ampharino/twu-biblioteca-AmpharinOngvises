package com.twu.biblioteca;


import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExampleTest {

    @Test
    public void test() {
        PrintStream printStream = mock(PrintStream.class);
        FakePrinter fakePrinter = new FakePrinter(printStream);
        fakePrinter.print("Hello World");
        verify(printStream).println("Hello World");

    }
}
