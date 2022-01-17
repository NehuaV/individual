package com.example.Player.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public Song(String title, String artist, String url) {
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

}

