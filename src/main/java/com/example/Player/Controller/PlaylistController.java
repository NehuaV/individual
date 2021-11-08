package com.example.Player.Controller;


import com.example.Player.Interfaces.IPlaylist;
import com.example.Player.Model.Playlist;
import com.example.Player.Model.Song;
import com.example.Player.repository.IPlaylistDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    IPlaylist repo;


}
