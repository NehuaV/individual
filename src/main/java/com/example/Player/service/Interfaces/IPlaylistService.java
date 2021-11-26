package com.example.Player.service.Interfaces;

import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> getAllPlaylists();
    Playlist getPlaylistByName(String name);
    void addPlaylist(Playlist playlist);
}
