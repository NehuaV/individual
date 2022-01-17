package com.example.Player.repository.JPA;

import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.model.Playlist;
import com.example.Player.model.User;
import com.example.Player.repository.IPlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistJPA implements IPlaylistDAL {

    IPlaylistRepo repo;
    @Autowired
    public PlaylistJPA(IPlaylistRepo repo) {
        this.repo = repo;
    }

    @Override
    public Playlist getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        return repo.findPlaylistByName(name);
    }

    @Override
    public Playlist saveAndFlush(Playlist playlist) {
        return repo.saveAndFlush(playlist);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        repo.delete(playlist);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Playlist> getAllByUser(User user) {
        return repo.getAllByUser(user);
    }

    @Override
    public List<Playlist> GetAllPlaylist() {
        return repo.findAll();
    }

}
