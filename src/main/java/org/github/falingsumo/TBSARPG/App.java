package org.github.falingsumo.TBSARPG;

import org.github.falingsumo.TBSARPG.game.GameEngine;
import org.github.falingsumo.TBSARPG.graphic.Console;
import org.github.falingsumo.TBSARPG.input.Keyboard;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GraphicEngine graphicEngine = new Console();
        InputMethod inputMethod = new Keyboard(System.in);
        GameEngine gameEngine = new GameEngine(graphicEngine, inputMethod);
        gameEngine.start();
    }
}
