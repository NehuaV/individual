package com.example.Player.service;

import com.example.Player.Model.Playlist;
import com.example.Player.dalinterfaces.IPlaylistDAL;
import org.springframework.beans.factory.annotation.Autowired;

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
