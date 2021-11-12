package com.example.Player.Controller;

import com.example.Player.LogicLayer.UserManager;
import com.example.Player.Model.User;
import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")

public class UserController {

    @Autowired
    IUserService service;

    @PostMapping()
    //POST at http://localhost:XXXX/country/
    public ResponseEntity<User> createCountry(@RequestBody User user) {
        service.addUser(user);
        //Create resource location
        var result = service.getUserByUsername(user.getUsername()).getId();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result)
                .toUri();

        //Send location in response (in the header)
        return ResponseEntity.created(location).build();
    }















//    @GetMapping
//    public ResponseEntity<List<User>> getUserByUsername(@RequestParam(value = "username") Optional<String> username) {
//        if (username.isPresent()) {
//            List<User> u = repo.GetUsers();
//            if (u != null) {
//                return ResponseEntity.ok().body(u);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//
//        } else {
//            List<User> users = repo.GetUsers();
//            if (users != null) {
//                return ResponseEntity.ok().body(users);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }
//
//    @GetMapping("/userId/{userId}")
//    public ResponseEntity<User> getUserByIds(@PathVariable Long userId) {
//        User user = data.getUserId(userId);
//        if (user != null) {
//            return ResponseEntity.ok().body(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
//        if (data.getUserId(id) != null) {
//            data.deleteUserId(id);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping()
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        if (!data.addUser(user)){
//            String entity =  "User with username {" + user.getUsername() + "} already exists.";
//            return new ResponseEntity(entity,HttpStatus.CONFLICT);
//        } else {
//            String url = "users/" + user.getUsername();
//            URI uri = URI.create(url);
//            return new ResponseEntity(uri,HttpStatus.CREATED);
//        }
//    }
//
//    @PutMapping()
//    public ResponseEntity<User> updateStudent(@RequestBody User user) {
//        if (data.updateUser(user)) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return new ResponseEntity("Please provide a valid User Data.",HttpStatus.NOT_FOUND);
//        }
//    }

}



