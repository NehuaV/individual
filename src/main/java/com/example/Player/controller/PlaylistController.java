package com.example.Player.controller;


import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;
import com.example.Player.service.Interfaces.IPlaylistService;
import com.example.Player.service.Interfaces.ISongService;
import com.example.Player.service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/playlist")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {

    @Autowired
    IUserService userService;

    @Autowired
    IPlaylistService playlistService;

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


    @GetMapping()
    public ResponseEntity<Iterable<PlaylistDTO>> getAllUserPlaylists(@RequestParam String userUsername) {
        List<PlaylistDTO> playDTO = playlistService.getAllByUser(userService.getUserByUsername(userUsername));
        for (PlaylistDTO playlistDTO : playDTO) {
            var songs = songService.getAllByPlaylistDTO(playlistService.getById(playlistDTO.getId()));
            playlistDTO.setSongs(songs);
        }
        if (playDTO != null)
            return new ResponseEntity<>(playDTO, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<String> addPlaylist(@RequestParam String playlistName,@RequestParam String userUsername) {
        User user = userService.getUserByUsername(userUsername);
        Playlist newPlaylist = new Playlist(playlistName);
        newPlaylist.setUser(user);
        playlistService.saveAndFlush(newPlaylist);
        return new ResponseEntity<>(playlistName+" has been added", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> removePlaylist(@RequestParam Long playlistId){
        return new ResponseEntity<>(playlistService.deleteById(playlistId),HttpStatus.OK);
    }



//    @GetMapping("/playlistAndSongs")
//    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylists2() {
//        List<PlaylistDTO> playDTO = playlistService.getAllPlaylistsDTO();
//        for (PlaylistDTO playlistDTO : playDTO) {
//            var songs = songService.getAllByPlaylistDTO(playlistService.getById(playlistDTO.getId()));
//            playlistDTO.setSongs(songs);
//        }
//        if (playDTO != null)
//            return new ResponseEntity<>(playDTO, HttpStatus.OK);
//        else
//            return ResponseEntity.notFound().build();
//    }

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
