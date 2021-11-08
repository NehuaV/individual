package com.example.Player.LogicLayer;

import com.example.Player.FakeData.MockData;
import com.example.Player.Interfaces.IPlaylist;
import com.example.Player.Model.Playlist;
import com.example.Player.Model.Song;
import com.example.Player.repository.IPlaylistDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaylistManager implements IPlaylistDAL {

    private List<Playlist> playlistList = new ArrayList<>();
    private MockData mockData;

    @Autowired
    IPlaylist iPlaylist;

    @Override
    public List<Playlist> GetAllPlaylist() {
        return iPlaylist.findAll();
    }

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
        Long i = 0L;
        for (Playlist playlist : this.playlistList){
            if(!playlist.getId().equals(i.toString()) || playlist == null){
                Playlist temp = new Playlist(i,name);
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
