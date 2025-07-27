package com.piturria.TasksWebApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        return http.csrf(customizer->customizer.disable())     //disable CSRF token (no default spring login page
                .authorizeHttpRequests(request->request
                        .requestMatchers("login", "register", "h2-console").permitAll()
                        .anyRequest().authenticated())   //enable authentication, so now all are 403 Forbidden without login
                //.formLogin(Customizer.withDefaults())       //enable spring default login page but now postman receives it too, if disable login will be asked by pop-up
                .httpBasic(Customizer.withDefaults())       //postman redirects to page when authenticated
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))        //for every resource you need to authorize so now login is redirect every request in browser
                .build();
//Lambda expression from functional interface
//        http.csrf(new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        });
    }

    //MANAGING our own user and password, ignoring the default one in configuration
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails fakeUser1 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles("USER")
                .build();
        UserDetails fakeUser2 = User.withDefaultPasswordEncoder()
                .username("admin")      //it should be unique
                .password("admin1")
                .roles("ADMIN")
                .build();
//        public InMemoryUserDetailsManager(UserDetails... users) {   <- that means several UserDetails with delimited by','
        return new InMemoryUserDetailsManager(fakeUser1,fakeUser2);
    }
    //Our own authentication provider to connect to DB
    //https://www.youtube.com/watch?v=bOX1VYNqKCY&list=PLsyeobzWxl7qbKoSgR5ub6jolI8-ocxCF&index=35

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        //NOT ENCODED PASSWORD
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        //ENCODED PASSWORD
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

}