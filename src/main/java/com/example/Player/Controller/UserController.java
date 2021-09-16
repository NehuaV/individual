package com.example.Player.Controller;

import com.example.Player.FakeData.MockData;
import com.example.Player.Model.User;
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
    public ResponseEntity<User> getUserByIds(@PathVariable int userId) {
        User user = mockData.getUserId(userId);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<User>> getUserByUsername(@PathVariable(value = "username") String username) {
        List<User> user = mockData.getUserUsername(username);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
