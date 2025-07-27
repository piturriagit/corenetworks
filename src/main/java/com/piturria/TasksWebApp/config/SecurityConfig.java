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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    //Our custom security filter chain: no csrf, stateless
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                //Disabling CSRF
                    //when enabled, you need CSRF header in update requests (not in get) even with successful authentication
                .csrf(customizer -> customizer.disable())

                //Specify which requests should go through authentication
                .authorizeHttpRequests(request -> request
//                        //Add pages to exclude for authentication
//                        .requestMatchers("login", "register","h2-console").permitAll()
//                        //Forcing authentication for remaining pages
//                        .anyRequest().authenticated())
                        .anyRequest().permitAll())
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

    //Our custom user detail service: no default user/password by spring boot security
    @Bean
    public UserDetailsService userDetailsService() {

        //Fake user to test user details service
        UserDetails fakeAdmin = User
                //so password not sent in authorization header basicauthplaintext
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("a@123")
                .roles("ADMIN")
                .build();
        UserDetails fakeUser = User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("u@123")
                .roles("USER")
                .build();

        //built-in implementation UserDetailService interface: InMemoryUserDetailsManager class
        return new InMemoryUserDetailsManager(fakeAdmin,fakeUser);
    }

    @Bean
    public AuthenticationProvider authenticationProvider () {

        //Authenticaton provider for database: Data Access Object
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //Skipping password enconder, to see password on our database
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService());
        return provider;

    }
}
