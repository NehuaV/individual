package com.example.Player.repository;

import com.example.Player.Model.Playlist;
import com.example.Player.dalinterfaces.IPlaylistDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistJPA implements IPlaylistDAL {

    @Autowired IPlaylist repo;

    @Override
    public List<Playlist> GetAllPlaylist() {
        return repo.findAll();
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        return repo.getPlaylistByName(name);
    }

    @Override
    public void addPlaylist(Playlist playlist) {
        repo.save(playlist);
    }

}
