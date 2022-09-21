package org.github.falingsumo.TBSARPG.game;

import org.github.falingsumo.TBSARPG.GraphicEngine;

public class GameEngine {
    private final GraphicEngine graphicEngine;
    public GameEngine(GraphicEngine graphicEngine) {
        this.graphicEngine = graphicEngine;
    }

    public void start() {
        this.graphicEngine.write("Hello world!");
    }
}
