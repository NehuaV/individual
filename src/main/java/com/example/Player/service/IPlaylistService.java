package com.example.Player.service;

import com.example.Player.Model.Playlist;

public interface IPlaylistService {
    Playlist getPlaylistByName(String name);
    void addPlaylist(Playlist playlist);
}
