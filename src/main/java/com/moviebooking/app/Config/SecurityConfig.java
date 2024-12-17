package com.moviebooking.app.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/movies/**", "/bookings/**").authenticated().requestMatchers("/", "/login", "/register").permitAll()).formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/movies", true)).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());

        return http.build();
    }

}