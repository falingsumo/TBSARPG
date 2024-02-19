package org.github.falingsumo.TBSARPG.server.health_check;

import java.util.Date;

public class HealthCheckResponse {
    public Date currentDate;
    public String buildVersion;

    public HealthCheckResponse(Date currentDate, String buildVersion) {
        this.currentDate = currentDate;
        this.buildVersion = buildVersion;
    }
}
