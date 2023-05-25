package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.service.UserService;
import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.domain.exceptions.IncorrectCredentialsException;
import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.domain.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final String SECRET_KEY = "abarrena0_uoc_edu";
    private static final long EXPIRATION_TIME = 86400000; // 24 hours in milliseconds

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(User user) throws IncorrectCredentialsException {
        User userInfo = findUserByUsername(user.getUsername());
        if (userInfo != null && userInfo.getPassword().equals(user.getPassword())) {
            return generateToken(userInfo);
        } else {
            throw new IncorrectCredentialsException();
        }
    }

    @Override
    public User findUserByUsername(String username) throws EntityNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    private String generateToken(User user) {
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
