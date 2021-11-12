package com.example.Player.Controller;


import com.example.Player.repository.IPlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/playlist")

public class PlaylistController {

    @Autowired
    IPlaylist repo;


}
