package edu.uoc.abarrena.users.infrastructure.authorization.config;

import edu.uoc.abarrena.users.infrastructure.authorization.jwt.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationConfig {

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }
}
