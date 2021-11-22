package com.example.Player.service;

import com.example.Player.model.Playlist;
import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.service.Interfaces.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService implements IPlaylistService {

    IPlaylistDAL dal;
    @Autowired
    public PlaylistService(IPlaylistDAL dal) {
        this.dal = dal;
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        return dal.getPlaylistByName(name);
    }

    @Override
    public void addPlaylist(Playlist playlist) {
        dal.addPlaylist(playlist);
    }
}
