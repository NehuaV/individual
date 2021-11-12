package com.example.Player.dalinterfaces;

import com.example.Player.Model.Playlist;

import java.util.List;

public interface IPlaylistDAL {
    List<Playlist> GetAllPlaylist();
    Playlist getPlaylistByName(String name);
    void addPlaylist(Playlist playlist);
}
