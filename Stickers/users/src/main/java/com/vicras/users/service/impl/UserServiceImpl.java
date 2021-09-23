package com.vicras.users.service.impl;

import com.vicras.lib.exceptions.EntityNotFoundException;
import com.vicras.users.domain.User;
import com.vicras.users.exceptoins.AuthorizationException;
import com.vicras.users.repository.UserRepository;
import com.vicras.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author viktar hraskou
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final JWTService jwtService;
    private final UserRepository userRepository;

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findUserByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException(User.class, login));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    }

    @Override
    public void saveUser(String name, String password) {
        var user = User.builder()
                .login(name)
                .password(encoder.encode(password))
                .build();

        userRepository.save(user);
    }

    @Override
    public void deleteUser(String name) {
        userRepository.deleteByLogin(name);
    }

    @Override
    public String getToken(String name, String password) {
        User user = getUserByLogin(name);
        if (encoder.matches(password, user.getPassword())) {
            return jwtService.getToken(user);
        }
        throw new AuthorizationException();
    }

    @Override
    public boolean isTokenValid(String token) {
        return jwtService.isValidToken(token);
    }
}
