package org.github.falingsumo.TBSARPG.server.health_check.service;

import org.github.falingsumo.TBSARPG.server.health_check.HealthCheckController;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class PropertiesBuildVersionService implements BuildVersionService {
    @Override
    public String getBuildVersion() throws BuildVersionUnavailableException {
        final Properties properties = new Properties();
        try {
            properties.load(HealthCheckController.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new BuildVersionUnavailableException("Build version unavailable");
        }
        return properties.getProperty("application.version");
    }
}
