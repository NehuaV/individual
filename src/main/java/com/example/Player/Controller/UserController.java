package com.example.Player.Controller;

import com.example.Player.FakeData.MockData;
import com.example.Player.LogicLayer.UserManager;
import com.example.Player.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private static final UserManager data = new UserManager();

    @GetMapping
    public ResponseEntity<List<User>> getUserByUsername(@RequestParam(value = "username") Optional<String> username) {
        if (username.isPresent()) {
            List<User> u = data.getUserUsername(username.get());
            if (u != null) {
                return ResponseEntity.ok().body(u);
            } else {
                return ResponseEntity.notFound().build();
            }

        } else {
            List<User> users = data.GetUsers();
            if (users != null) {
                return ResponseEntity.ok().body(users);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<User> getUserByIds(@PathVariable int userId) {
        User user = data.getUserId(userId);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deletePost(@PathVariable int id) {
        if (data.getUserId(id) != null) {
            data.deleteUserId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}



