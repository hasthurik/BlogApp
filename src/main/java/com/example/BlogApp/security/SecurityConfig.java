package com.example.BlogApp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


    //своя настройка филтров
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(customizer -> customizer.disable()).  //отключение csrf
                authorizeHttpRequests(request -> request.anyRequest().authenticated()). //любой запрос требует аунтефикации
                httpBasic(Customizer.withDefaults()).  //включаем HTTP basic аунтефикацию
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();  //Устанавливает политику создания сессий как STATELESS
    }

    //своя настройка провайдера
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); //пользователь из бд
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());  // отключение кодировщика паролей
        provider.setUserDetailsService(userDetailsService); // Устанавливаем UserDetailsService
        return provider;
    }

}
