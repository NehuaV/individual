package com.example.Player.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="song")
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id", unique = true)
    private Playlist playlist;

    @Transient
    public Long getId() {
        return id;
    }

    public Song(String title, String artist, String url) {
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    public Song() {

    }
}

