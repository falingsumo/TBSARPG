package org.github.falingsumo.TBSARPG.server.health_check;

import org.github.falingsumo.TBSARPG.server.health_check.service.BuildVersionService;
import org.github.falingsumo.TBSARPG.server.health_check.service.LocalizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("health-check/" + HealthCheckController.APIVersion)
public class HealthCheckController {
    public static final String APIVersion = "v1";

    private final BuildVersionService buildVersionService;
    private final LocalizationService localizationService;

    public HealthCheckController(BuildVersionService buildVersionService, LocalizationService localizationService) {
        this.buildVersionService = buildVersionService;
        this.localizationService = localizationService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> healthCheck(Locale locale) {
        try {
            return new ResponseEntity<>(new HealthCheckResponseDTO(this.localizationService.format(Instant.now(), locale), this.buildVersionService.getBuildVersion(), locale), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
