package com.example.Player.controller;


import com.example.Player.dto.SongDTO;
import com.example.Player.model.Song;
import com.example.Player.service.Interfaces.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/song")
@CrossOrigin(origins = "http://localhost:3000")
public class SongsController {
    @Autowired
    ISongService service;

    @GetMapping("/songs")
    public ResponseEntity<Iterable<SongDTO>> getAllSongs()  {
        var songs = service.getAllSongs();
        if(songs != null) {
            return new ResponseEntity<>(service.getAllSongs(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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


