package com.github.nodji.discoveryserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desabilitar CSRF (opcional para APIs stateless)
            .csrf(csrf -> csrf.disable())
            // Todas as requisições precisam ser autenticadas
            .authorizeHttpRequests(authz -> authz
                .anyRequest().authenticated()
            )
            // Habilitar autenticação HTTP Basic
            .httpBasic(customizer -> {
                // Aqui você pode adicionar configurações personalizadas se necessário
            })
            // Configuração para não manter estado de sessão (stateless)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        return http.build();
    }
}
