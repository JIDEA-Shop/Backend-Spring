package com.cogent.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This is a starter Security Configuration.
 * Allowing only 3 ADMIN Role to use all funtions.
 */
@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails duc = User.builder()
                .username("duc")
                .password("{noop}duc@111")
                .roles("ADMIN")
                .build();
        UserDetails javier = User.builder()
                .username("javier")
                .password("{noop}javier@111")
                .roles("ADMIN")
                .build();
        UserDetails evan = User.builder()
                .username("evan")
                .password("{noop}evan@111")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(evan,javier,duc);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(config->
                config
                        .requestMatchers(HttpMethod.DELETE,"api/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"api/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"api/**").hasRole("ADMIN")
                        );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
