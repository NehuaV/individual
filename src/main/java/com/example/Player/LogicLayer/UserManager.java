package com.example.Player.LogicLayer;

import com.example.Player.FakeData.MockData;
import com.example.Player.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> userList = new ArrayList<>();
    private MockData mockData = new MockData();

    public UserManager(){
        userList = mockData.getUserList();
    }

    public List<User> GetUsers() {
        return this.userList;
    }

    public User getUserId(int id) {
        for (User user : this.userList) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUserId(int id) {
        User user = getUserId(id);
        if (user == null){
            return false;
        }
        return userList.remove(user);
    }

    public List<User> getUserUsername(String userName) {
        List<User> temp = new ArrayList<>();
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                temp.add(user);
            }
        }
        return temp;
    }

    public boolean addUser(User user) {
        if (this.getUserId(user.getUserId()) != null){
            return false;
        }
        userList.add(user);
        return true;
    }

}
