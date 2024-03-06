package org.github.falingsumo.TBSARPG.server.health_check.service.localization;

import org.github.falingsumo.TBSARPG.server.health_check.service.LocalizationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class ResourceBundleLocalizationService implements LocalizationService {
    @Override
    public String format(Instant instant, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        String format = bundle.getString("general.date.format");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format)
                .withZone(ZoneId.of("UTC"));
        return formatter.format(instant);
    }
}
