package com.example.Player.service;

import com.example.Player.Model.Song;
import com.example.Player.dalinterfaces.ISongDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    ISongDAL dal;
    @Autowired
    public SongService(ISongDAL dal){this.dal = dal;}

    @Override
    public List<Song> getAllSongs() {
        return dal.GetAllSongs();
    }

    @Override
    public Song getSongByTitle(String title) {
        return dal.getSongByTitle(title);
    }

    @Override
    public void addSong(Song song) { dal.addSong(song); }
}
