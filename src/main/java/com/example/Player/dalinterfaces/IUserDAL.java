package com.example.Player.dalinterfaces;

import com.example.Player.model.User;

import java.util.Collection;
import java.util.Optional;

public interface IUserDAL {
    
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User SaveAndFlush(User user);
    Collection<User> findAll();
    void deleteById(Long id);
    Optional<User> findById(Long id);
}
