package com.example.Player.controller;


import com.example.Player.dalinterfaces.IRoleDAL;
import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.dto.UserDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import com.example.Player.model.User;
import com.example.Player.repository.IPlaylistRepo;
import com.example.Player.security.JwtToken.JwtProvider;
import com.example.Player.service.Interfaces.IPlaylistService;
import com.example.Player.service.Interfaces.IRoleService;
import com.example.Player.service.Interfaces.ISongService;
import com.example.Player.service.Interfaces.IUserService;

import com.example.Player.utils.RoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IPlaylistService playlistService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider tokenProvider;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody User user) {

        JSONObject jsonObject = new JSONObject();
        try {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setRole(roleService.findRoleByName(RoleEnum.USER.toString()));
            User savedUser = userService.saveOrUpdate(user);
            jsonObject.put("message", savedUser.getUsername() + " saved successfully");
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        } catch (JSONException e) {

            // Implement returning Error
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
    }

    // Login Method
    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(@RequestBody User user) {
        // Creates a JSON object and puts user data
        JSONObject jsonObject = new JSONObject();
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                String email = user.getEmail();
                jsonObject.put("email", authentication.getName());
                jsonObject.put("authorities", authentication.getAuthorities());
                jsonObject.put("token", tokenProvider.createToken(email, userService.findUserByEmail(email).getRole()));
                return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
            }
        } catch (JSONException e) {

            // Implement returning Error
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
        return null;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<Iterable<UserDTO>> getAllUsers()  {
        var songs = userService.findAll();
        if(songs != null) {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




//    @PostMapping()
//    //POST at http://localhost:XXXX/country/
//    public ResponseEntity<User> createCountry(@RequestBody User user) {
//        service.addUser(user);
//        //Create resource location
//        var result = service.getUserByUsername(user.getUsername()).getId();
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(result)
//                .toUri();
//
//        //Send location in response (in the header)
//        return ResponseEntity.created(location).build();

//    }

//    @PutMapping("/user/{userName}/playList/{playlistName}")
//    public ResponseEntity<User> addPlaylist(@PathVariable String playlistName,@PathVariable String userName) {
//        User user = service.getUserByUsername(userName);
//        Playlist playlist = playlistService.getPlaylistByName(playlistName);
//        user.addPlaylist(playlist);
//        return null;
//    }
//    @PostMapping("/register")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        if (service.getUserByUsername(user.getUsername()) == user){
//            String entity =  "User with username {" + user.getUsername() + "} already exists.";
//            return new ResponseEntity(entity,HttpStatus.CONFLICT);
//        } else {
//            String url = "users/" + user.getUsername();
//            URI uri = URI.create(url);
//            service.addUser(user);
//            return new ResponseEntity(uri,HttpStatus.CREATED);

//        }

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
//
//}



