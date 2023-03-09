package org.github.falingsumo.TBSARPG.input;

import org.github.falingsumo.TBSARPG.InputMethod;

import java.io.InputStream;
import java.util.Scanner;

public class Keyboard implements InputMethod {
    private final Scanner scanner;

    public Keyboard(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String read() {
        return this.scanner.nextLine();
    }
}
