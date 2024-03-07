package org.github.falingsumo.TBSARPG.server.services;

import org.github.falingsumo.TBSARPG.server.services.build_version.ApplicationPropertiesUnavailableException;

public interface ApplicationPropertiesService {
    String getApplicationProperty(String key) throws ApplicationPropertiesUnavailableException;
}
