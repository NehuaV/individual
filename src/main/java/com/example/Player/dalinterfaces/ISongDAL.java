package com.example.Player.dalinterfaces;

import com.example.Player.dto.SongDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.Song;

import java.util.List;

public interface ISongDAL {
    Song getSongByTitle (String title);

    Song saveAndFlush(Song song);

    void deleteSong(Song song);
    void deleteById(Long id);

    List<Song> GetAllByPlaylist(Playlist playlist);
    List<Song> GetAllSongs();
}
