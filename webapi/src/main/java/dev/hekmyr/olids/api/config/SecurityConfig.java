package dev.hekmyr.olids.api.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.httpBasic(Customizer.withDefaults());
    http.cors(cors ->
      cors.configurationSource(request -> {
        var config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(
          Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        return config;
      })
    );
    http.authorizeHttpRequests(auth -> {
      auth
        .requestMatchers("/api/v1/public/**")
        .permitAll()
        .anyRequest()
        .authenticated();
    });
    http.sessionManagement(session -> {
      session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    });
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}
