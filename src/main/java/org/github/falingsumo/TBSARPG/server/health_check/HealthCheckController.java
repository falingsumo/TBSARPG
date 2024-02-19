package org.github.falingsumo.TBSARPG.server.health_check;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-check")
public class HealthCheckController {

    @GetMapping
    public String healthCheck() {
        return "testing health-check";
    }
}
