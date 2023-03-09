package org.github.falingsumo.TBSARPG.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KeyboardTest {
    private final ByteArrayOutputStream inContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;

    @Mock
    private InputStream inputStream;

    private Keyboard keyboard;

    @Before
    public void setup() {
        System.setIn(this.inputStream);
        this.keyboard = new Keyboard(this.inputStream);
    }

    @After
    public void tearDown() {
        System.setIn(this.originalIn);
    }

    @Test
    public void givenAScanner_whenReadingInput_thenTheScannerReadsTheNextLine() {
        this.keyboard.read();
        verify(this.inputStream, times(1)).nextLine();
    }
}