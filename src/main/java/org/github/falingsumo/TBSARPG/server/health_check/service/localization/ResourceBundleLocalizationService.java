package org.github.falingsumo.TBSARPG.server.health_check.service.localization;

import org.github.falingsumo.TBSARPG.server.health_check.service.LocalizationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class ResourceBundleLocalizationService implements LocalizationService {
    @Override
    public String format(Instant instant, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        bundle.getString("general.date.format");

        return "";
    }
}
