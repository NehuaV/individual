package com.example.Player.repository;

import com.example.Player.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Long> {
    Song findSongByTitle(String title);
}
