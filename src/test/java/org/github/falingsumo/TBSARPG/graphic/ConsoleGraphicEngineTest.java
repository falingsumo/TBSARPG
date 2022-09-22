package org.github.falingsumo.TBSARPG.graphic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleGraphicEngineTest {
    private static final String A_STRING = "Hello world";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ConsoleGraphicEngine consoleGraphicEngine;

    @Before
    public void setup() {
        System.setOut(new PrintStream(this.outContent));

        this.consoleGraphicEngine = new ConsoleGraphicEngine();
    }

    @After
    public void tearDown() {
        System.setOut(this.originalOut);
    }

    @Test
    public void givenAString_whenWritingALine_thenSystemOutPrintlnShouldWriteTheString() {
        this.consoleGraphicEngine.writeLine(A_STRING);
        assertEquals(A_STRING, this.outContent.toString().trim());
    }
}