package com.example.Player.dalinterfaces;

import com.example.Player.model.Playlist;
import com.example.Player.model.User;

import java.util.List;

public interface IPlaylistDAL {
    Playlist getById(Long id);
    Playlist getPlaylistByName(String name);
    Playlist getByUserAndId(User user, Long id);
    Playlist saveAndFlush(Playlist playlist);

    void deletePlaylist(Playlist playlist);
    void deleteById(Long id);

    List<Playlist> GetAllPlaylist();
    List<Playlist> getAllByUser(User user);
}
