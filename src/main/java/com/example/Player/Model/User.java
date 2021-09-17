package com.example.Player.Model;

import lombok.Getter;

public class User {
    int userId;
    String username;
    String email;
    String password;

    public User (int userId,String username)
    {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
