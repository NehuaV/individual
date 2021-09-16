package com.example.demo.Controller;

import com.example.demo.FakeData.MockData;
import com.example.demo.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final MockData mockData = new MockData();

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = mockData.GetUsers();
        if (users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = mockData.getUserId(userId);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/userName/")
    public ResponseEntity<User> getUserByUsername(@RequestParam String userName) {
        User user = mockData.getUserUsername(userName);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
