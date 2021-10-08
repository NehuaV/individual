package com.example.Player.LogicLayer;

import com.example.Player.FakeData.MockData;
import com.example.Player.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongsManager {

    private List<Song> songList = new ArrayList<>();
    private MockData mockData = new MockData();

    public SongsManager(){
        this.songList = mockData.getSongList();
    }

    public List<Song> GetAllSongs(){
        return songList;
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
