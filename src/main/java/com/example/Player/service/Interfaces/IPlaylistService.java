package com.example.Player.service.Interfaces;

import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> getAllPlaylistsDTO();
    Playlist getPlaylistByName(String name);
    void addPlaylist(Playlist playlist);
    List<Playlist> getAllPlaylists();
    Playlist getById(Long Id);
    List<PlaylistDTO> getAllByUser(User user);
}
