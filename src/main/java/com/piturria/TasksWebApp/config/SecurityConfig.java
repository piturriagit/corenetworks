package com.piturria.TasksWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                //Disabling CSRF
                    //when enabled, you need CSRF header in update requests (not in get) even with successful authentication
                .csrf(customizer -> customizer.disable())

                //Forcing authentication for all pages
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())

                //Enabling login form: if security is enabled show default springboot login page
                    //login pop-up when disabling
                //.formLogin(Customizer.withDefaults())

                //Disabling loing form for postman
                .httpBasic(Customizer.withDefaults())

                //Make HTTP stateless (not remember you, new sessionid for every request)
                    //So when sending credentials from login, redirects to login.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                //Build your custom filter chain according to previous configuration
                .build();
    }
}
