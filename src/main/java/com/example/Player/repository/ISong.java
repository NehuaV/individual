package com.example.Player.repository;

import com.example.Player.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISong extends JpaRepository<Song,Long> {
    Song getSongByTitle(String title);
}
