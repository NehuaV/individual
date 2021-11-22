package com.example.Player.service.Interfaces;

import com.example.Player.model.Playlist;

public interface IPlaylistService {
    Playlist getPlaylistByName(String name);
    void addPlaylist(Playlist playlist);
}
