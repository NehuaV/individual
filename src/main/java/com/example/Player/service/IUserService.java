package com.example.Player.service;

import com.example.Player.Model.Song;
import com.example.Player.Model.User;

public interface IUserService {
    User getUserByUsername(String username);
    void addUser(User user);
}
