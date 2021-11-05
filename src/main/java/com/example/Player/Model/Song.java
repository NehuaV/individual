package com.example.Player.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="artist")
    private String artist;
    @Column(name = "url")
    private String url;

    public Song(String title){
        this.title = title;
    }

    public Song(String title, String artist, String url){
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    public Song() {
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setUrl(String link) {
        this.url = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(url, song.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, url);
    }
}
