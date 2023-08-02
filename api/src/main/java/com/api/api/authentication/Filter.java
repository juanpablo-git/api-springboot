package com.api.api.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * filter
 */
@Configuration
@EnableWebSecurity
public class Filter {

        @Autowired
        BeforeFilter beforeFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
            return httpSecurity
            .csrf(csrf-> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.POST, "/login").permitAll()
                                           .requestMatchers(HttpMethod.POST,"/products").hasRole("ADMIN")
                                            .requestMatchers(HttpMethod.DELETE,"/products").hasRole("ADMIN")
                                            .requestMatchers(HttpMethod.GET,"/products").hasAnyRole("USER")
                                            .anyRequest().authenticated()
                                )
            .addFilterBefore(beforeFilter,UsernamePasswordAuthenticationFilter.class)
            .build();
        }
}