package com.example.Player.dalinterfaces;

import com.example.Player.Model.User;

import java.util.List;

public interface IUserDAL {
    List<User> GetUsers();
    void addUser(User user);
    User getUserByUsername(String username);
}
