package org.github.falingsumo.TBSARPG.server.health_check.service;

public interface BuildVersionService {
    String getBuildVersion() throws BuildVersionUnavailableException;
}
