package com.study.first_lab.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Value("${security.logins}")
    private List<String> logins;
    @Value("${security.passwords}")
    private List<String> passwords;
    @Value("${security.roles}")
    private List<String> roles;

    @Bean
    public UserDetailsService userDetailsService (PasswordEncoder encoder) {
        List<UserDetails> userDetailList = new ArrayList<>();
        for (int i = 0; i < logins.size(); i++) {
            if (passwords.get(i) != null && roles.get(i) != null) {
                System.out.println(logins.get(i) + " added.");
                userDetailList.add(User.builder().username(logins.get(i)).password(encoder.encode(passwords.get(i))).roles(roles.get(i)).build());
            } 
        }
        return new InMemoryUserDetailsManager(userDetailList);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        System.out.println("CHAIN");
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/projects/open").permitAll()
                .requestMatchers("/projects/*").authenticated()
            )
            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
