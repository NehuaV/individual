package com.example.Player.service.Interfaces;

import com.example.Player.dto.PlaylistDTO;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;

import java.util.List;

public interface IPlaylistService {
    Playlist getById(Long Id);
    Playlist getPlaylistByName(String name);
    Playlist saveAndFlush(Playlist playlist);

    void addPlaylist(Playlist playlist);

    List<PlaylistDTO> getAllPlaylistsDTO();
    List<Playlist> getAllPlaylists();
    List<PlaylistDTO> getAllByUser(User user);
}
