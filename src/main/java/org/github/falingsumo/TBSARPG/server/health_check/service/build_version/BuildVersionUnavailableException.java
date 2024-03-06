package org.github.falingsumo.TBSARPG.server.health_check.service.build_version;

public class BuildVersionUnavailableException extends Exception {
    BuildVersionUnavailableException(String message) {
        super(message);
    }
}
