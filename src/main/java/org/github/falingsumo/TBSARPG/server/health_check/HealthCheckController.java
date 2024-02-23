package org.github.falingsumo.TBSARPG.server.health_check;

import org.github.falingsumo.TBSARPG.server.health_check.service.BuildVersionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("health-check/" + HealthCheckController.APIVersion)
public class HealthCheckController {
    public static final String APIVersion = "v1";

    private final BuildVersionService buildVersionService;

    public HealthCheckController(BuildVersionService buildVersionService) {
        this.buildVersionService = buildVersionService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> healthCheck() {
        try {
            return new ResponseEntity<>(new HealthCheckResponseDTO(new Date(), this.buildVersionService.getBuildVersion()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
