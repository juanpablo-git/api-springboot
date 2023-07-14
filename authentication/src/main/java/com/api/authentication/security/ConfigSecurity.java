package com.api.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.authentication.security.filter.BeforeFilter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {
    @Autowired
    BeforeFilter beforeFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf->csrf.disable()).authorizeHttpRequests(requests-> requests.anyRequest().permitAll()).addFilterBefore(beforeFilter,UsernamePasswordAuthenticationFilter.class).build();
    }
    
}
