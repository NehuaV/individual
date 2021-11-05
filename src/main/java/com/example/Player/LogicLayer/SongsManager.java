package com.example.Player.LogicLayer;

import com.example.Player.FakeData.MockData;
import com.example.Player.Interfaces.ISong;
import com.example.Player.Model.Song;
import com.example.Player.repository.ISongDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongsManager implements ISongDAL {

    private List<Song> songList = new ArrayList<>();
    private MockData mockData = new MockData();

    @Autowired
    ISong iSong;

    public SongsManager(){
//        this.songList = GetAllSongs();
    }

    @Override
    public List<Song> GetAllSongs(){
        return iSong.findAll();
    }

    public Song getSongByTitle(String title) {
        for (Song song : this.songList) {
            if (song.getTitle() == title) {
                return song;
            }
        }
        return null;
    }

    public boolean addSong(Song song) {
        if (this.getSongByTitle(song.getTitle()) != null){
            return false;
        }
        songList.add(song);
        return true;
    }

    public boolean deleteSongByTitle(String title) {
        Song song = getSongByTitle(title);
        if (song == null){
            return false;
        }
        return songList.remove(song);
    }

}
