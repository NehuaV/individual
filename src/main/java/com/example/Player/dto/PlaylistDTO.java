package com.example.Player.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlaylistDTO {
    private Long id;
    private String name;
    private List<SongDTO> songs;
    public void addSong(SongDTO songDTO) {songs.add(songDTO);}
}
