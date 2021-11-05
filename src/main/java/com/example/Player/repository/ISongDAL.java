package com.example.Player.repository;

import com.example.Player.Model.Song;

import java.util.List;

public interface ISongDAL {
    List<Song> GetAllSongs();
}
