package edu.uoc.abarrena.users;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .disable()
                .cors()
                .and()
                .authorizeHttpRequests((auth) -> auth
                        // Users
                        .requestMatchers(HttpMethod.POST, "/users/login").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasAnyRole("ADMIN")
                        // Travelers
                        .requestMatchers(HttpMethod.POST, "/travelers").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/travelers/**").hasAnyRole("TRAVELER")
                        .requestMatchers(HttpMethod.GET, "/travelers/**").hasAnyRole("TRAVELER", "ADMIN", "COMPANY")
                        // Companies
                        .requestMatchers(HttpMethod.POST, "/companies").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/companies/**").hasAnyRole("COMPANY")
                        .requestMatchers(HttpMethod.GET, "/companies/**").permitAll()
                        // Dive diary
                        .requestMatchers(HttpMethod.POST, "/dive-diary").hasAnyRole("TRAVELER")
                        .requestMatchers(HttpMethod.GET, "/dive-diary").hasAnyRole("TRAVELER")
                        // Favourite search
                        .requestMatchers(HttpMethod.POST, "/favourite-searches").hasAnyRole("TRAVELER")
                        .requestMatchers(HttpMethod.GET, "/favourite-searches").hasAnyRole("TRAVELER")
                        .requestMatchers(HttpMethod.DELETE, "/favourite-searches/**").hasAnyRole("TRAVELER")
                )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey key = Keys.hmacShaKeyFor(extendKey(SECRET_KEY));
        return NimbusJwtDecoder.withSecretKey(key).build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        final JwtGrantedAuthoritiesConverter gac = new JwtGrantedAuthoritiesConverter();
        gac.setAuthoritiesClaimName("role");
        gac.setAuthorityPrefix("ROLE_");

        final JwtAuthenticationConverter jac = new JwtAuthenticationConverter();
        jac.setJwtGrantedAuthoritiesConverter(gac);
        return jac;
    }

    private byte[] extendKey(String key) {
        byte[] extendedKey = new byte[32];
        for (int i = 0; i < key.length(); i++) {
            extendedKey[i] = (byte) key.charAt(i);
        }
        return extendedKey;
    }
}
