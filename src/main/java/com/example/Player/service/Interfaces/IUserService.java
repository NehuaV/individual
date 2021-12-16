package com.example.Player.service.Interfaces;

import com.example.Player.dto.UserDTO;
import com.example.Player.dto.UserProfileDTO;
import com.example.Player.model.User;

import java.util.Collection;
import java.util.Optional;

public interface IUserService {

    Optional<User> findById(Long id);
    User getUserByUsername(String username);
    UserDTO getByUsernameDTO(String username);
    User findUserByEmail(String email);
    User saveOrUpdate(User user);
    UserProfileDTO getUserProfile(String username);

    String deleteById(Long id);
    Collection<UserDTO> findAll();
}
