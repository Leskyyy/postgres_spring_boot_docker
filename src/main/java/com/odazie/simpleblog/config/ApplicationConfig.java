package com.odazie.simpleblog.config;

import com.odazie.simpleblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;
    @Bean
    public UserDetailsService userDetailsService() {
        return email -> repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));
    }
}
