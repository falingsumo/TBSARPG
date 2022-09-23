package org.github.falingsumo.TBSARPG.input;

import org.github.falingsumo.TBSARPG.InputMethod;

import java.util.Scanner;

public class Keyboard implements InputMethod {
    private final Scanner scanner;

    public Keyboard(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String read() {
        return this.scanner.nextLine();
    }
}
