package org.github.falingsumo.TBSARPG;

import org.github.falingsumo.TBSARPG.game.GameEngine;
import org.github.falingsumo.TBSARPG.graphic.ConsoleGraphicEngine;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        GraphicEngine graphicEngine = new ConsoleGraphicEngine();
        System.out.println("Hello World!");
    }
}
