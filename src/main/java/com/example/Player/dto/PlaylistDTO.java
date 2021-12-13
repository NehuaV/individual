package com.example.Player.dto;

import com.example.Player.model.Song;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistDTO {
    private Long id;
    private String name;
    private List<SongDTO> songs;
    public void addSong(SongDTO songDTO) {songs.add(songDTO);}
}
