package com.example.Player.service;

import com.example.Player.Model.User;
import com.example.Player.dalinterfaces.ISongDAL;
import com.example.Player.dalinterfaces.IUserDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    IUserDAL dal;
    @Autowired
    public UserService(IUserDAL dal){
        this.dal = dal;
    }

    @Override
    public void addUser(User user){dal.addUser(user);}

    @Override
    public User getUserByUsername(String Username){ return dal.getUserByUsername(Username);}
}
