package com.example.Player.repository;

import com.example.Player.Model.Playlist;

import java.util.List;

public interface IPlaylistDAL {
    List<Playlist> GetAllPlaylist();
}
