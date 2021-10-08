package com.example.Player.Model;


import com.example.Player.LogicLayer.SongsManager;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String id;
    private String name;
    private SongsManager songsManager = new SongsManager();
    List<Song> songsList = new ArrayList<Song>();

    public Playlist(String id,String name){
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void AddSong(String title){
        Song temp = songsManager.getSongByTitle(title);
        songsList.add(temp);
    }

    public boolean RemoveSong(String title){
        Song temp = songsManager.getSongByTitle(title);
        if(temp != null){
            songsList.remove(temp);
            return true;
        }
        return false;
    }

}
