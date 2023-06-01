package edu.uoc.abarrena.users.infrastructure.authorization.jwt;

import edu.uoc.abarrena.users.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private Long EXPIRATION_TIME;

    public String generateToken(User user) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        SecretKey key = Keys.hmacShaKeyFor(extendKey(SECRET_KEY));

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole());
        claims.put("id", user.getId());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private byte[] extendKey(String key) {
        byte[] extendedKey = new byte[32];
        for (int i = 0; i < key.length(); i++) {
            extendedKey[i] = (byte) key.charAt(i);
        }
        return extendedKey;
    }

}
