package com.example.Player.repository;

import com.example.Player.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User getUserByUsername(String username);
    User findUserByEmail(String email);
    void deleteById(Long id);
}
