package com.example.Player.repository.JPA;

import com.example.Player.dalinterfaces.ISongDAL;
import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import com.example.Player.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SongJPA implements ISongDAL {

    ISongRepo repo;

    @Autowired
    public SongJPA(ISongRepo repo) {
        this.repo = repo;
    }

    @Override
    public Song getSongByTitle(String title) {
        return repo.findSongByTitle(title);
    }

    @Override
    public List<Song> GetAllSongs() {
        return repo.findAll();
    }

    @Override
    public Song saveAndFlush(Song song) {
        return repo.saveAndFlush(song);
    }

    @Override
    public void deleteSong(Song song) {
        repo.delete(song);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Song> GetAllByPlaylist(Playlist playlist) {
        return repo.findAllByPlaylist(playlist);
    }
}
