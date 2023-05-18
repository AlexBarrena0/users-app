package edu.uoc.abarrena.users.domain.service;

import edu.uoc.abarrena.users.application.UserService;
import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
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
    public String login(User user) {
        User userInfo = findUserByUsername(user.getUsername());
        if (userInfo != null && userInfo.getPassword().equals(user.getPassword())) {
            return generateToken(userInfo);
        } else {
            return null;
        }
    }

    @Override
    public User findUserByUsername(String username) throws EntityNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    private String generateToken(User user) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole());

         return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
