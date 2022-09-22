package org.github.falingsumo.TBSARPG.game;

import org.github.falingsumo.TBSARPG.GraphicEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {
    @Mock
    private GraphicEngine graphicEngine;
    private GameEngine gameEngine;

    @Before
    public void setup() {
        this.gameEngine = new GameEngine(this.graphicEngine);
    }

    @Test
    public void whenStartingAGame_thenTheGraphicEngineShouldWriteHelloWorld() {
        this.gameEngine.start();
        verify(this.graphicEngine, times(1)).writeLine("Hello world!");
    }
}