package com.example.Player.controller;


import com.example.Player.dto.PlaylistDTO;
import com.example.Player.dto.SongDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import com.example.Player.model.User;
import com.example.Player.repository.IPlaylistRepo;
import com.example.Player.service.Interfaces.IPlaylistService;
import com.example.Player.service.Interfaces.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {

    @Autowired
    IPlaylistService service;

    @Autowired
    ISongService songService;

//    @GetMapping("/allPlaylists")
//    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylistsDTO() {
//        var playlists = service.getAllPlaylistsDTO();
//        if (playlists != null) {
//            return new ResponseEntity<>(service.getAllPlaylistsDTO(), HttpStatus.OK);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/userPlaylist/aa")
    public ResponseEntity<Iterable<PlaylistDTO>> getAllUserPlaylists() {
        List<PlaylistDTO> playDTO = service.getAllPlaylistsDTO();
        for (PlaylistDTO playlistDTO : playDTO) {
            var songs = songService.getAllByPlaylistDTO(service.getById(playlistDTO.getId()));
            playlistDTO.setSongs(songs);
        }
        if (playDTO != null)
            return new ResponseEntity<>(playDTO, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();

    }

    @GetMapping("/playlistAndSongs")
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylists2() {
        List<PlaylistDTO> playDTO = service.getAllPlaylistsDTO();
        for (PlaylistDTO playlistDTO : playDTO) {
            var songs = songService.getAllByPlaylistDTO(service.getById(playlistDTO.getId()));
            playlistDTO.setSongs(songs);
        }
        if (playDTO != null)
            return new ResponseEntity<>(playDTO, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();

    }

//    @GetMapping("/allPlaylistsTest")
//    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylists()  {
//        var playlists = service.getAllPlaylists();
//        var send = new ArrayList<PlaylistDTO>();
//        for(Playlist playlist: playlists){
//            var playlistDTO = new PlaylistDTO();
//            var songs = songService.getAllByPlaylistDTO(playlist);
//            playlistDTO.setSongs(songs);
//            send.add(playlistDTO);
//        }
//
//        if(send != null) {
//            return new ResponseEntity<>(send, HttpStatus.OK);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
