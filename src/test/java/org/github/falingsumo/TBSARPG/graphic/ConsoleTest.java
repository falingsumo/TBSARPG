package org.github.falingsumo.TBSARPG.graphic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleTest {
    private static final String A_STRING = "Hello world";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Console console;

    @Before
    public void setup() {
        System.setOut(new PrintStream(this.outContent));

        this.console = new Console();
    }

    @After
    public void tearDown() {
        System.setOut(this.originalOut);
    }

    @Test
    public void givenAString_whenWritingALine_thenSystemOutPrintlnShouldWriteTheString() {
        this.console.writeLine(A_STRING);
        assertEquals(A_STRING, this.outContent.toString().trim());
    }
}