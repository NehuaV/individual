package com.example.Player.Interfaces;

import com.example.Player.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylist extends JpaRepository<Playlist,Long> {
}
