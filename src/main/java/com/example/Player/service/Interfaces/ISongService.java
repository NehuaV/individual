package com.example.Player.service.Interfaces;

import com.example.Player.dto.SongDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.Song;

import java.util.List;

public interface ISongService {
    Song getSongByTitle (String title);

    Song saveAndFlush(Song song);
    String deleteById(Long id);

    List<SongDTO> getAllSongs();
    List<SongDTO> getAllByPlaylistDTO(Playlist playlist);
}
