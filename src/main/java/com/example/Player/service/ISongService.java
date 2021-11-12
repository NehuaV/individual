package com.example.Player.service;

import com.example.Player.Model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAllSongs();
    Song getSongByTitle (String title);
    void addSong(Song song);
}
