package com.springboot.blog.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableMethodSecurity
@SecurityScheme(name = "Bear Authentication",
type = SecuritySchemeType.HTTP,
bearerFormat = "JWT",
scheme = "bearer")
public class SecurityConfig {

    private UserDetailsService userDetailsService;

}
