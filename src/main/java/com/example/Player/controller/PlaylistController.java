package com.example.Player.controller;


import com.example.Player.repository.IPlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/playlist")

public class PlaylistController {

    @Autowired
    IPlaylistRepo repo;


}
