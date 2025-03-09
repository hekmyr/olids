package dev.hekmyr.olids.api.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
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

  @Value("${cors.allowed-origins}")
  private List<String> allowedOrigins;

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.httpBasic(Customizer.withDefaults());
    http.cors(cors ->
      cors.configurationSource(request -> {
        var config = new CorsConfiguration();
        config.setAllowedOrigins(allowedOrigins);
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
