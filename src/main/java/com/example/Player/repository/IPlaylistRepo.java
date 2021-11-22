package com.example.Player.repository;

import com.example.Player.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepo extends JpaRepository<Playlist,Long> {
    Playlist findPlaylistByName(String name);
}
