package org.github.falingsumo.TBSARPG.graphic;

import org.github.falingsumo.TBSARPG.GraphicEngine;

public class Console implements GraphicEngine {
    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }
}
