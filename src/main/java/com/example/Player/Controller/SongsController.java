package com.example.Player.Controller;


import com.example.Player.Model.Song;
import com.example.Player.repository.ISongDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    ISongDAL repo;

    @GetMapping
    public ResponseEntity<List<Song>> getSongByName(@RequestParam(value = "song") Optional<String> song) {
        if (song.isPresent()) {
            List<Song> u = repo.GetAllSongs();
            if (u != null) {
               // System.out.println(u.stream().count());
                return ResponseEntity.ok().body(u);
            } else {
                return ResponseEntity.notFound().build();
            }

        } else {
            List<Song> songs = repo.GetAllSongs();
            if (songs != null) {
               // System.out.println(songs.stream().count());
                return ResponseEntity.ok().body(songs);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

}
