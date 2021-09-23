package com.vicras.users.service;

import com.vicras.users.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author viktar hraskou
 */
@Service
public interface UserService {

    User getUserByLogin(String login);

    User getUserById(Long id);

    void saveUser(String name, String password);

    void deleteUser(String name);

    String getToken(String name, String password);

    boolean isTokenValid(String token);

}
