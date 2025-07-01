package com.bahelix.spring_boot_microservice_1_inmueble.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


  @Value("${service.security.secure-key-username}")
  private String SECURE_KEY_USERNAME;

  @Value("${service.security.secure-key-password}")
  private String SECURE_KEY_PASSWORD;

  @Value("${service.security.secure-key-username-2}")
  private String SECURE_KEY_USERNAME_2;

  @Value("${service.security.secure-key-password-2}")
  private String SECURE_KEY_PASSWORD_2;


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .anyRequest().hasRole("ADMIN")
      )
      .csrf(csrf -> csrf.disable())
      .httpBasic(httpBasic -> {})
      .exceptionHandling(ex -> ex
        .accessDeniedHandler(accessDeniedHandler())
      );

      return http.build();
  }

  
  @Bean
  public UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
      User.builder()
        .username(SECURE_KEY_USERNAME)
        .password(passwordEncoder().encode(SECURE_KEY_PASSWORD))
        .roles("ADMIN")
        .build(),
      User.builder()
        .username(SECURE_KEY_USERNAME_2)
        .password(passwordEncoder().encode(SECURE_KEY_PASSWORD_2))
        .roles("DEV")
        .build()
    );
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
    return (request, response, accessDeniedException) -> 
      response.sendRedirect("https://google.com");
  }

}
