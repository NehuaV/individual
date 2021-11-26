package com.example.Player.dto;

import lombok.Data;

@Data
public class SongDTO {
    private Long id;
    private String title;
    private String artist;
    private String url;
}
