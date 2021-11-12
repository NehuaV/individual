package com.example.Player.Controller;


import com.example.Player.Model.Playlist;
import com.example.Player.Model.Song;
import com.example.Player.Model.User;
import com.example.Player.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/song")

public class SongsController {

    @Autowired
    ISongService service;

    @GetMapping
    public ResponseEntity<Iterable<Song>> getAllCountries()  {
        var songs = service.getAllSongs();
        if(songs != null) {
            return ResponseEntity.ok().body(songs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
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

    @PostMapping()
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        service.addSong(song);
        //Create resource location
        var result = service.getSongByTitle(song.getTitle()).getId().intValue();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result)
                .toUri();

        //Send location in response (in the header)
        return ResponseEntity.created(location).build();
    }
}


