package org.github.falingsumo.TBSARPG.server.health_check.service;

import org.github.falingsumo.TBSARPG.server.health_check.service.build_version.BuildVersionUnavailableException;

public interface BuildVersionService {
    String getBuildVersion() throws BuildVersionUnavailableException;
}
