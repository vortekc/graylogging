package com.graylogging.graylogging.log;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    LoggerContextFilter kfLoggerContextFilter() {
        return new LoggerContextFilter();
    }

    @Bean
    FilterRegistrationBean<?> registration(final LoggerContextFilter kfLoggerContextFilter) {
        FilterRegistrationBean<LoggerContextFilter> registrationBean = new FilterRegistrationBean<>(kfLoggerContextFilter);
        registrationBean.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER - 10);
        registrationBean.setEnabled(true);

        return registrationBean;
    }
}
