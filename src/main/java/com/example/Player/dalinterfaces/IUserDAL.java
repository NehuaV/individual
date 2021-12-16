package com.example.Player.dalinterfaces;

import com.example.Player.model.User;

import java.util.Collection;
import java.util.Optional;

public interface IUserDAL {
    
    User getUserByUsername(String username);
    User findUserByEmail(String email);
    User SaveAndFlush(User user);

    void deleteById(Long id);

    Collection<User> findAll();
    Optional<User> findById(Long id);
}
