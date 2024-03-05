package org.github.falingsumo.TBSARPG.server.health_check;

import java.util.Locale;

public class HealthCheckResponseDTO {
    public String currentInstant;
    public String buildVersion;

    public Locale locale;

    public HealthCheckResponseDTO(String currentInstant, String buildVersion, Locale locale) {
        this.currentInstant = currentInstant;
        this.buildVersion = buildVersion;
        this.locale = locale;
    }
}
