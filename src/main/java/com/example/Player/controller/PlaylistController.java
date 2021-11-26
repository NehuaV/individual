package com.example.Player.controller;


import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;
import com.example.Player.repository.IPlaylistRepo;
import com.example.Player.service.Interfaces.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {

    @Autowired
    IPlaylistService service;

    @GetMapping("/allPlaylists")
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylists()  {
        var songs = service.getAllPlaylists();
        if(songs != null) {
            return new ResponseEntity<>(service.getAllPlaylists(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
