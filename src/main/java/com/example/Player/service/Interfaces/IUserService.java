package com.example.Player.service.Interfaces;

import com.example.Player.dto.UserDTO;
import com.example.Player.model.User;

import java.util.Collection;
import java.util.Optional;

public interface IUserService {

    Optional<User> findById(Long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User saveOrUpdate(User user);

    String deleteById(Long id);
    Collection<UserDTO> findAll();
}
