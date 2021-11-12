package com.example.Player.LogicLayer;

import com.example.Player.FakeData.MockData;
import com.example.Player.repository.IUser;
import com.example.Player.Model.User;
import com.example.Player.dalinterfaces.IUserDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class UserManager {
//
//    private List<User> userList = new ArrayList<>();
//    private MockData mockData = new MockData();
//
//    @Autowired
//    IUser iUser;
//
//    public UserManager(){
//    }
//
//    @Override
//    public List<User> GetUsers() {
//        return iUser.findAll();
//    }
//
//    // For testing purposes
//    public UserManager(List<User> userlist){
//        userList = userlist;
//    }
//
//    public List<User> GetAllUsers() {
//        return this.userList;
//    }
//
//
//    public User getUserId(Long id) {
//        for (User user : this.userList) {
//            if ((user.getId().equals(id))) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public boolean deleteUserId(Long id) {
//        User user = getUserId(id);
//        if (user.equals(null)){
//            return false;
//        }
//        return userList.remove(user);
//    }
//
//    public List<User> getUserUsername(String userName) {
//        List<User> temp = new ArrayList<>();
//        for (User user : userList) {
//            if (user.getUsername().equals(userName)) {
//                temp.add(user);
//            }
//        }
//        return temp;
//    }
//
//    public void addUser(User user) {
//        if (this.getUserId(user.getId()) != null){
//            userList.add(user);
//        }
//    }
//
//    @Override
//    public User getUserByUsername(String username) {
//        return I;
//    }
//
//    public boolean updateUser(User user) {
//        User old = this.getUserId(user.getId());
//        if (old == null) { return false; }
//        int index = userList.indexOf(old);
//        userList.set(index, user);
//        return true;
//    }

}
