package com.example.Player.repository;

import com.example.Player.Model.Song;
import com.example.Player.dalinterfaces.ISongDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SongJPA implements ISongDAL {
    @Autowired
    ISong repo;

    @Override
    public Song getSongByTitle(String title) {
        return repo.getSongByTitle(title);
    }

    @Override
    public List<Song> GetAllSongs() {
        return repo.findAll();
    }

    @Override
    public void addSong(Song song) { repo.save(song); }
}
