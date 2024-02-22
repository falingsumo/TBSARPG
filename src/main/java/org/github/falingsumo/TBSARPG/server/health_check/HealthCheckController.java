package org.github.falingsumo.TBSARPG.server.health_check;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("health-check/" + HealthCheckController.version)
public class HealthCheckController {
    public static final String version = "v1";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HealthCheckResponseDTO> healthCheck() {
        return new ResponseEntity<>(new HealthCheckResponseDTO(new Date(), "0.0.1-SNAPSHOT"), HttpStatus.OK);
    }
}
