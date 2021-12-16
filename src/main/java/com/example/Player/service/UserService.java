package com.example.Player.service;

import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.dto.UserDTO;
import com.example.Player.model.User;
import com.example.Player.service.Interfaces.IUserService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    IUserDAL dal;
    @Autowired
    public UserService(IUserDAL dal){
        this.dal = dal;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Optional<User> findById(Long id) {
        return dal.findById(id);
    }

    @Override
    public User findUserByUsername(String Username){ return dal.findUserByUsername(Username);}

    @Override
    public User findUserByEmail(String email) {
        return dal.findUserByEmail(email);
    }

    @Override
    public User saveOrUpdate(User user) {
        return dal.SaveAndFlush(user);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject json = new JSONObject();
        try {
            dal.deleteById(id);
            json.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    @Override
    public Collection<UserDTO> findAll() {
        return dal.findAll()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO EntityToDTO(User user){
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
}
