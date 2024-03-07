package org.github.falingsumo.TBSARPG.server.services.localization;

import org.github.falingsumo.TBSARPG.server.services.ApplicationPropertiesService;
import org.github.falingsumo.TBSARPG.server.services.LocalizationService;
import org.github.falingsumo.TBSARPG.server.services.build_version.ApplicationPropertiesUnavailableException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class ResourceBundleLocalizationService implements LocalizationService {
    private static final String BUNDLE_NAME = "messages";
    private static final String DATE_FORMAT_KEY = "general.date.format";

    private final ApplicationPropertiesService applicationPropertiesService;

    ResourceBundleLocalizationService(ApplicationPropertiesService applicationPropertiesService) {
        this.applicationPropertiesService = applicationPropertiesService;
    }


    @Override
    public String format(Instant instant, Locale locale) {
        String format = this.translate(DATE_FORMAT_KEY, locale);
        DateTimeFormatter formatter;
        try {
            formatter = DateTimeFormatter.ofPattern(format)
                    .withZone(ZoneId.of(this.applicationPropertiesService.getApplicationProperty("application.timezone.default")));
        } catch (ApplicationPropertiesUnavailableException e) {
            throw new RuntimeException(e);
        }
        return formatter.format(instant);
    }

    @Override
    public String translate(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        return bundle.getString(key);
    }

    @Override
    public String translate(String key, Locale locale, Object... args) {
        String message = this.translate(key, locale);
        return String.format(message, args);
    }
}
