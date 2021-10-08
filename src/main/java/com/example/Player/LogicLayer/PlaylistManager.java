package com.example.Player.LogicLayer;

import com.example.Player.FakeData.MockData;
import com.example.Player.Model.Playlist;
import com.example.Player.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    private List<Playlist> playlistList = new ArrayList<>();
    private MockData mockData;

    public PlaylistManager(){

    }

    public Playlist getPlaylistByName(String name) {
        for (Playlist playlist : this.playlistList) {
            if (playlist.getName() == name) {
                return playlist;
            }
        }
        return null;
    }

    public Playlist CreatePlaylist(String name) {
        Integer i = 0;
        for (Playlist playlist : this.playlistList){
            if(!playlist.getId().equals(i.toString()) || playlist == null){
                Playlist temp = new Playlist(i.toString(),name);
                return temp;
            }
            i++;
        }
        return null;
    }

    public boolean DeletePlaylistByName(String name) {
        Playlist playlist = getPlaylistByName(name);
        if (playlist == null){
            return false;
        }
        return playlistList.remove(playlist);
    }

}
