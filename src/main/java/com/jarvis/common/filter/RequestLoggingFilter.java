package com.jarvis.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestLoggingFilter
        extends OncePerRequestFilter {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    RequestLoggingFilter.class
            );

    private static final String CORRELATION_ID =
            "correlationId";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String correlationId =
                UUID.randomUUID().toString();

        MDC.put(CORRELATION_ID, correlationId);

        long startTime =
                System.currentTimeMillis();

        logger.info(
                "Incoming Request | method={} | uri={} | correlationId={}",
                request.getMethod(),
                request.getRequestURI(),
                correlationId
        );

        try {

            filterChain.doFilter(
                    request,
                    response
            );

        } finally {

            long duration =
                    System.currentTimeMillis()
                            - startTime;

            logger.info(
                    "Outgoing Response | status={} | duration={}ms | correlationId={}",
                    response.getStatus(),
                    duration,
                    correlationId
            );

            MDC.clear();
        }
    }
}