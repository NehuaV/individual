package com.example.Player.Model;


import com.example.Player.LogicLayer.SongsManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "playlist")
    List<Song> songs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Playlist(Long id,String name){
        this.name = name;
        this.id = id;
    }

    public Playlist() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public void AddSong(String title){
//        Song temp = songsManager.getSongByTitle(title);
//        songsList.add(temp);
//    }
//
//    public boolean RemoveSong(String title){
//        Song temp = songsManager.getSongByTitle(title);
//        if(temp != null){
//            songsList.remove(temp);
//            return true;
//        }
//        return false;
//    }

}
