package com.example.Player.repository;

import com.example.Player.model.Playlist;
import com.example.Player.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlaylistRepo extends JpaRepository<Playlist,Long> {
    Playlist findPlaylistByName(String name);
    Playlist getById(Long id);
    List<Playlist> getAllByUser(User user);
}
