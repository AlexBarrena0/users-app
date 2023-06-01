package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.service.UserService;
import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.domain.exceptions.IncorrectCredentialsException;
import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.domain.repository.UserRepository;
import edu.uoc.abarrena.users.infrastructure.authorization.jwt.JwtTokenUtil;
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

    private final JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public String login(User user) throws IncorrectCredentialsException {
        User userInfo = findUserByUsername(user.getUsername());
        if (userInfo != null && userInfo.getPassword().equals(user.getPassword())) {
            return jwtTokenUtil.generateToken(userInfo);
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

}
