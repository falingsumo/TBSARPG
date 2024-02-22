package org.github.falingsumo.TBSARPG.server.health_check;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Properties;

@RestController
@RequestMapping("health-check/" + HealthCheckController.APIVersion)
public class HealthCheckController {
    public static final String APIVersion = "v1";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> healthCheck() {
        try {
            final Properties properties = new Properties();
            properties.load(HealthCheckController.class.getClassLoader().getResourceAsStream("application.properties"));
            return new ResponseEntity<>(new HealthCheckResponseDTO(new Date(), properties.getProperty("application.version")), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }
}
