package org.github.falingsumo.TBSARPG.server.health_check;

import org.github.falingsumo.TBSARPG.server.services.ApplicationPropertiesService;
import org.github.falingsumo.TBSARPG.server.services.LocalizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Locale;

@RestController
@RequestMapping("health-check/" + HealthCheckController.API_VERSION)
public class HealthCheckController {
    public static final String API_VERSION = "v1";
    private static final String APPLICATION_VERSION_PROPERTY_KEY = "application.version";

    private final ApplicationPropertiesService applicationPropertiesService;
    private final LocalizationService localizationService;

    public HealthCheckController(ApplicationPropertiesService applicationPropertiesService, LocalizationService localizationService) {
        this.applicationPropertiesService = applicationPropertiesService;
        this.localizationService = localizationService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> healthCheck(Locale locale) {
        try {
            return new ResponseEntity<>(new HealthCheckResponseDTO(this.localizationService.format(Instant.now(), locale), this.applicationPropertiesService.getApplicationProperty(APPLICATION_VERSION_PROPERTY_KEY), locale), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
