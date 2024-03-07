package org.github.falingsumo.TBSARPG.server.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.github.falingsumo.TBSARPG.server.services.LocalizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.stream.Collectors;

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
        StringBuilder params = new StringBuilder();
        Collections.list(request.getParameterNames()).forEach(param -> params.append("{ \"").append(param).append("\": \"").append(request.getParameter(param)).append("\" }"));

        StringBuilder requestHeaders = new StringBuilder();
        Collections.list(request.getHeaderNames()).forEach(header -> requestHeaders.append("{ \"").append(header).append("\": \"").append(request.getHeader(header)).append("\" }"));

        String requestBody;
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        } else {
            requestBody = "\"\"";
        }

        log.info(
                this.localizationService.translate(
                        "log.request.message",
                        new Locale("en"),
                        request.getRequestId(),
                        request.getMethod(),
                        request.getRequestURL().toString(),
                        params.toString().replaceAll("}\\{", "}, {"),
                        requestHeaders.toString().replaceAll("}\\{", "}, {"),
                        requestBody
                )
        );

        String responseBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        if (responseBody.isEmpty()) {
            responseBody = "\"\"";
        }
        StringBuilder responseHeaders = new StringBuilder();
        response.getHeaderNames().forEach(header -> responseHeaders.append("{ \"").append(header).append("\": \"").append(response.getHeader(header)).append("\" }"));
        log.info(
                this.localizationService.translate(
                        "log.response.message",
                        new Locale("en"),
                        request.getRequestId(),
                        HttpStatus.valueOf(response.getStatus()),
                        responseHeaders.toString().replaceAll("}\\{", "}, {"),
                        responseBody
                )
        );
        filterChain.doFilter(request, response);
    }
}
