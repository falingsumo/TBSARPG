package org.github.falingsumo.TBSARPG.server.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.github.falingsumo.TBSARPG.server.services.LocalizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class HTTPLoggingFilter extends OncePerRequestFilter {

    private final Logger log = LoggerFactory.getLogger(HTTPLoggingFilter.class);
    private final LocalizationService localizationService;

    HTTPLoggingFilter(LocalizationService localizationService) {
        super();
        this.localizationService = localizationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info(this.localizationService.translate("log.request.message", request.getLocale()));
        filterChain.doFilter(request, response);
    }
}
