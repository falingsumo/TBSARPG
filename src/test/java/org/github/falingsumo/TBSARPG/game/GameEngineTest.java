package org.github.falingsumo.TBSARPG.game;

import org.github.falingsumo.TBSARPG.GraphicEngine;
import org.github.falingsumo.TBSARPG.InputMethod;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {
    private static final String AN_INPUT_STRING = "INPUT STRING";

    @Mock
    private GraphicEngine graphicEngine;
    @Mock
    private InputMethod inputMethod;

    private GameEngine gameEngine;

    @Before
    public void setup() {
        this.gameEngine = new GameEngine(this.graphicEngine, this.inputMethod);
    }

    @Test
    public void givenAGraphicEngine_whenStartingAGame_thenTheGraphicEngineShouldWriteHelloWorld() {
        this.gameEngine.start();
        verify(this.graphicEngine, times(1)).writeLine("Hello world!");
    }

    @Test
    public void givenAnInputMethod_whenStartingAGame_thenTheInputMethodShouldReadALine() {
        this.gameEngine.start();
        verify(this.inputMethod, times(1)).readLine();
    }

    @Test
    public void givenAnInputString_whenStartingAGame_thenTheGraphicEngineShouldWriteTheInputString() {
        when(this.inputMethod.readLine()).thenReturn(AN_INPUT_STRING);
        this.gameEngine.start();
        verify(this.graphicEngine, times(1)).writeLine(AN_INPUT_STRING);
    }
}