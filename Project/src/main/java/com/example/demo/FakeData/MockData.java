package com.example.demo.FakeData;

import com.example.demo.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    private List<User> userList;

    public MockData() {
        this.userList = new ArrayList<>(List.of(
                new User(0, "Pablo"),
                new User(1, "Tommy"),
                new User(2, "Jenny"),
                new User(3, "Lenny")
        ));
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

    public User getUserUsername(String userName) {
        for (User user : this.userList) {
            if (user.getUsername() == userName) {
                return user;
            }
        }
        return null;
    }
}
