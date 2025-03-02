package dev.hekmyr.olids.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.httpBasic(Customizer.withDefaults());
    http.authorizeHttpRequests(auth -> {
      auth
        .requestMatchers("/api/v1/public/**")
        .permitAll()
        .anyRequest()
        .authenticated();
    });
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}
