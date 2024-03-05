package org.github.falingsumo.TBSARPG.server.health_check.service;

import java.time.Instant;
import java.util.Locale;

public interface LocalizationService {
    String format(Instant instant, Locale locale);
}
