package com.projectmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa proteção CSRF (para facilitar testes com Postman)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Libera acesso a todos os endpoints
                )
                .formLogin(login -> login.disable()) // Desativa tela de login padrão
                .httpBasic(basic -> basic.disable()); // Desativa autenticação básica

        return http.build();
    }
}
