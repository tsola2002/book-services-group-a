package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails seun = User.builder()
                .username("seun")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager (john,mary,seun);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/v1/students").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/v1/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/v1/students/{id}").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/students/{id}").hasRole("ADMIN")
        );
//        use http basic auth
        http.httpBasic(Customizer.withDefaults());
//        disable cross site forgery requests (CSRF)
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
