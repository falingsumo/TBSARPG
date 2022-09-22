package org.github.falingsumo.TBSARPG.game;

import org.github.falingsumo.TBSARPG.GraphicEngine;
import org.github.falingsumo.TBSARPG.InputMethod;

public class GameEngine {
    private final GraphicEngine graphicEngine;
    private final InputMethod inputMethod;

    public GameEngine(GraphicEngine graphicEngine, InputMethod inputMethod) {
        this.graphicEngine = graphicEngine;
        this.inputMethod = inputMethod;
    }

    public void start() {
        this.graphicEngine.writeLine("Hello world!");
        String test = this.inputMethod.readLine();
        this.graphicEngine.writeLine(test);
    }
}
