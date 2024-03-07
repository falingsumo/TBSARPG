package org.github.falingsumo.TBSARPG.server.services.build_version;

import org.github.falingsumo.TBSARPG.server.services.ApplicationPropertiesService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class ResourcesApplicationPropertiesService implements ApplicationPropertiesService {
    private static final String APPLICATION_PROPERTIES_FILE_NAME = "application.properties";
    public static final String EXCEPTION_MESSAGE_KEY = "exception.application.properties.unavailable.message";

    private final Properties properties;

    ResourcesApplicationPropertiesService() {
        this.properties = new Properties();
    }

    @Override
    public String getApplicationProperty(String key) throws ApplicationPropertiesUnavailableException {
        try {
            properties.load(ResourcesApplicationPropertiesService.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE_NAME));
        } catch (IOException e) {
            throw new ApplicationPropertiesUnavailableException(EXCEPTION_MESSAGE_KEY);
        }
        return properties.getProperty(key);
    }
}
