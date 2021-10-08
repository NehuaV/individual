package com.example.Player.Model;

import java.util.Objects;

public class Song {
    private String title;
    private String artist;
    private String link;

    public Song(String title){
        this.title = title;
    }

    public Song(String title, String artist, String link){
        this.title = title;
        this.artist = artist;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLink() {
        return link;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(link, song.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, link);
    }
}
