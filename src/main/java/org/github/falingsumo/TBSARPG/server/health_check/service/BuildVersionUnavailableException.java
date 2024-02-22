package org.github.falingsumo.TBSARPG.server.health_check.service;

public class BuildVersionUnavailableException extends RuntimeException {
    BuildVersionUnavailableException(String message) {
        super(message);
    }
}
