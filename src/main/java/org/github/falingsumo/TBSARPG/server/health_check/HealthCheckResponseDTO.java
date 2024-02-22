package org.github.falingsumo.TBSARPG.server.health_check;

import java.util.Date;

public class HealthCheckResponseDTO {
    public Date currentDate;
    public String buildVersion;

    public HealthCheckResponseDTO(Date currentDate, String buildVersion) {
        this.currentDate = currentDate;
        this.buildVersion = buildVersion;
    }
}
