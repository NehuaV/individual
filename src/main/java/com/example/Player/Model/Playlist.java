package com.example.Player.Model;


import com.example.Player.LogicLayer.SongsManager;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="playlist")
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    private String name;

    @OneToMany(mappedBy = "playlist")
    List<Song> songs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", unique = true)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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
