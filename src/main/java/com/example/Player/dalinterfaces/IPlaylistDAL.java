package com.example.Player.dalinterfaces;

import com.example.Player.model.Playlist;
import com.example.Player.model.User;

import java.util.List;

public interface IPlaylistDAL {
    List<Playlist> GetAllPlaylist();
    Playlist getPlaylistByName(String name);
    void addPlaylist(Playlist playlist);
    Playlist getById(Long id);
    List<Playlist> getAllByUser(User user);
}
