package com.example.Player.model;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;

    @OneToMany(targetEntity = Song.class, mappedBy = "playlist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Song> songs;
    

    public void addSong(Song song){
        songs.add(song);
    }

    @Transient
    public Long getId() {
        return id;
    }

    public Playlist(String name){
        this.name = name;
    }

    public Playlist() {
    }


}
