package com.example.Player.repository;

import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISongRepo extends JpaRepository<Song,Long> {
    Song findSongByTitle(String title);
    List<Song> findAllByPlaylist(Playlist playlist);
}
