package com.example.oktasecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests((authorize) -> authorize.requestMatchers("/api/whoami").authenticated()) // All requests require authentication
                .oauth2ResourceServer(oath2 -> oath2.jwt(Customizer.withDefaults())) // validates access tokens as JWTs
                .cors(Customizer.withDefaults())
                .build();
    }
}