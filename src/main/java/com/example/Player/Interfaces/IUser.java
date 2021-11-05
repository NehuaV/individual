package com.example.Player.Interfaces;

import com.example.Player.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User,Long> {
}
