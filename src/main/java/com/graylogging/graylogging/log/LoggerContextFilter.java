package com.graylogging.graylogging.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoggerContextFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logRequest(request);

        String randomTraceId = RandomStringUtils.random(10, true, true);
        MDC.put(KfMDC.TRACE, randomTraceId);

        response.setHeader("tracestate", "tr="+randomTraceId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            logResponse(response);
            MDC.clear();
        }
    }

    private void logRequest(HttpServletRequest request) {
        MDC.put(KfMDC.HTTP_METHOD, request.getMethod());
        MDC.put(KfMDC.HTTP_URI, request.getRequestURI());

        log.info("Request processing");
    }

    private void logResponse(HttpServletResponse response) {
        MDC.put(KfMDC.HTTP_STATUS, String.valueOf(response.getStatus()));
    }
}
