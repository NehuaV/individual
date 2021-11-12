package com.example.Player.repository;

import com.example.Player.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylist extends JpaRepository<Playlist,Long> {
    Playlist getPlaylistByName(String name);
}
