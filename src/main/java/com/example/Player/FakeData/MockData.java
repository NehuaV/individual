package com.example.Player.FakeData;

import com.example.Player.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    private List<User> userList;

    public MockData() {
        this.userList = new ArrayList<>();

        User a = new User(0, "Pablo");
        User b = new User(1, "Tommy");
        User c = new User(2, "Jenny");
        User d = new User(3, "Lenny");

        userList.add(a);
        userList.add(b);
        userList.add(c);
        userList.add(d);

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

    public List<User> getUserUsername(String userName) {
        List<User> temp = new ArrayList<>();

        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                temp.add(user);
            }
        }
        return temp;
    }
}
