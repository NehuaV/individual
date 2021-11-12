package com.example.Player.repository;

import com.example.Player.Model.User;
import com.example.Player.dalinterfaces.IUserDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJPA implements IUserDAL {

    @Autowired
    IUser repo;

    @Override
    public List<User> GetUsers() {
        return repo.findAll();
    }

    public User getUserByUsername(String username){return repo.getUserByUsername(username);}

    @Override
    public void addUser(User user) {
        repo.save(user);
    }
}
