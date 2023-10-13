package com.dda.crbc.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * CORS configuration for all environments.
 */
@Slf4j
@Configuration
public class CorsPolicy {

    /**
     * CORS configuration for local, all origins and methods are allowed.
     *
     * @return
     */
    @Profile({"local"})
    @Bean(name = "corsConfigurationSource")
    CorsConfigurationSource corsConfigurationSourceLocalAndDev() {
        log.info("Local/Dev CORS policy applied");
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
