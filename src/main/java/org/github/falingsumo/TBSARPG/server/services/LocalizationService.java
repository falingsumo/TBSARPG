package org.github.falingsumo.TBSARPG.server.services;

import java.time.Instant;
import java.util.Locale;

public interface LocalizationService {
    String format(Instant instant, Locale locale);
    String translate(String key, Locale locale);
    String translate(String key, Locale locale, Object... args);
}
