package com.example.Player.Model;

import com.example.Player.LogicLayer.PlaylistManager;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="username")
    String username;
    @Column(name="email")
    String email;
    @Column(name="password")
    String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Playlist> playlists;

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Transient
    public Long getId() {
        return id;
    }

    public User() {

    }

    public User (Long id ,String username, String email, String password)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User (String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
