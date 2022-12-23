package dev.ososuna.eazybank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  
  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests()
      .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
      .requestMatchers("/notices", "/contact").permitAll()
      .and().formLogin()
      .and().httpBasic();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
