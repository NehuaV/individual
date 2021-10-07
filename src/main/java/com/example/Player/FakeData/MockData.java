package com.example.Player.FakeData;

import com.example.Player.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    private List<User> userList;

    public MockData() {
        this.userList = new ArrayList<>();

        User a = new User(0, "Pablo","test1@email.com","12341234");
        User b = new User(1, "Tommy","test2@email.com","12341234");
        User c = new User(2, "Jenny","test3@email.com","12341234");
        User d = new User(3, "Lenny","test4@email.com","12341234");

        userList.add(a);
        userList.add(b);
        userList.add(c);
        userList.add(d);

    }

    public List<User> getUserList() {
        return userList;
    }
}
