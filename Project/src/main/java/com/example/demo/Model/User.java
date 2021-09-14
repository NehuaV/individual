package com.example.demo.Model;

import lombok.Getter;

public class User {

    @Getter int userId;
    @Getter String username;
    @Getter String email;
    @Getter String password;

    public User (int userId,String username)
    {
        this.userId = userId;
        this.username = username;
    }
}
