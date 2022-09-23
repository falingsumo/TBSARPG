package org.github.falingsumo.TBSARPG.input;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Scanner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class KeyboardTest {
    @Mock
    private Scanner scanner;

    private Keyboard keyboard;

    @Before
    public void setup() {
        this.keyboard = new Keyboard(this.scanner);
    }

    @Test
    public void givenAScanner_whenReadingInput_thenTheScannerReadsTheNextLine() {
        this.keyboard.read();
        verify(this.scanner, times(1)).nextLine();
    }
}