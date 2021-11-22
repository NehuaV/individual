package com.example.Player.service.Interfaces;

import com.example.Player.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAllSongs();
    Song getSongByTitle (String title);
    void addSong(Song song);
}
