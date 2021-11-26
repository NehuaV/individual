package com.example.Player.service.Interfaces;

import com.example.Player.dto.SongDTO;
import com.example.Player.model.Song;

import java.util.List;

public interface ISongService {
    List<SongDTO> getAllSongs();
    Song getSongByTitle (String title);
    void addSong(Song song);
}
