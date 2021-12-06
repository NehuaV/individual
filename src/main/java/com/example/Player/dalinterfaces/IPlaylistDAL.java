package com.example.Player.dalinterfaces;

import com.example.Player.model.Playlist;
import com.example.Player.model.User;

import java.util.List;

public interface IPlaylistDAL {
    Playlist getById(Long id);
    Playlist getPlaylistByName(String name);
    Playlist saveAndFlush(Playlist playlist);

    void addPlaylist(Playlist playlist);

    List<Playlist> GetAllPlaylist();
    List<Playlist> getAllByUser(User user);
}
