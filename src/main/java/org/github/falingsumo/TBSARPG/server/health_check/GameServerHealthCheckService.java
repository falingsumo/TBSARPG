package org.github.falingsumo.TBSARPG.server.health_check;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GameServerHealthCheckService implements HealthCheckService {
    @Override
    public HealthCheckResponse healthCheck() {
        return new HealthCheckResponse(new Date(), "0.0.1-SNAPSHOT");
    }
}