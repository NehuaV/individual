package com.example.Player.controller;


import com.example.Player.model.Song;
import com.example.Player.service.Interfaces.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/song")

public class SongsController {


//    @GetMapping
//    public ResponseEntity<List<Song>> getSongByName(@RequestParam(value = "song") Optional<String> song) {
//        User user = new User("user", "123", "123");
//        Playlist playlist = new Playlist("Playlist");
//        playlist.addSong(new Song("", "", "https://www.youtube.com/watch?v=O48hUxxJxS8"));
//        playlist.addSong(new Song("", "", "https://www.youtube.com/watch?v=8B93tgRxMuE"));
//        playlist.addSong(new Song("", "", "https://www.youtube.com/watch?v=YE0WmmEn7Yk"));
//        user.addPlaylist(playlist);
//

//        if (song.isPresent()) {
//            List<Song> u = repo.GetAllSongs();
//            if (u != null) {
//               // System.out.println(u.stream().count());
//                return ResponseEntity.ok().body(u);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//
//        } else {
//            List<Song> songs = repo.GetAllSongs();
//            if (songs != null) {
//               // System.out.println(songs.stream().count());
//                return ResponseEntity.ok().body(songs);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }
//        return null;
//    }


}


