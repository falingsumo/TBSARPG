package org.github.falingsumo.TBSARPG.input;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.InputStream;

public class KeyboardTest {
    @Mock
    private InputStream inputStream;

    private Keyboard keyboard;

    @Before
    public void setup() {
        this.keyboard = new Keyboard(this.inputStream);
    }

    @Test
    public void given_when_then() {

    }
}