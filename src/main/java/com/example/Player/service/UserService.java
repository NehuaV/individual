package com.example.Player.service;

import com.example.Player.model.User;
import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.service.Interfaces.IUserService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    IUserDAL dal;
    @Autowired
    public UserService(IUserDAL dal){
        this.dal = dal;
    }

    @Override
    public User findUserByUsername(String Username){ return dal.findUserByUsername(Username);}

    @Override
    public User findUserByEmail(String email) {
        return dal.findUserByEmail(email);
    }

    @Override
    public Collection<User> findAll() {
        return dal.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return dal.findById(id);
    }

    @Override
    public User saveOrUpdate(User user) {
        return dal.SaveAndFlush(user);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            dal.deleteById(id);
            jsonObject.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
