package org.github.falingsumo.TBSARPG.server.health_check;

import java.time.Instant;
import java.util.Locale;

public class HealthCheckResponseDTO {
    public Instant currentInstant;
    public String buildVersion;

    public Locale locale;

    public HealthCheckResponseDTO(Instant currentInstant, String buildVersion, Locale locale) {
        this.currentInstant = currentInstant;
        this.buildVersion = buildVersion;
        this.locale = locale;
    }
}
