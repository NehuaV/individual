package com.example.Player.dalinterfaces;

import com.example.Player.model.Playlist;
import com.example.Player.model.Song;

import java.util.List;

public interface ISongDAL {
    List<Song> GetAllSongs();
    Song getSongByTitle (String title);
    void addSong(Song song);
    List<Song> GetAllByPlaylist(Playlist playlist);
}
