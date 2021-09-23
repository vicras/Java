package com.vicras.users.repository;

import com.vicras.users.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author viktar hraskou
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

    void deleteByLogin(String login);
}
