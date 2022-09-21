package org.github.falingsumo.TBSARPG;

import org.github.falingsumo.TBSARPG.game.GameEngine;
import org.github.falingsumo.TBSARPG.graphic.ConsoleGraphicEngine;

public class App {
    public static void main(String[] args) {
        GraphicEngine graphicEngine = new ConsoleGraphicEngine();
        GameEngine gameEngine = new GameEngine(graphicEngine);
        System.out.println("Hello World!");
    }
}
