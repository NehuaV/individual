package com.example.Player.Model;

import com.example.Player.LogicLayer.PlaylistManager;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    int userId;
    String username;
    String email;
    String password;

    List<Playlist> playlists = new ArrayList<>();
    private PlaylistManager p = new PlaylistManager();

    public User (int userId,String username,String email,String password)
    {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean AddPlaylist(String name){
        Playlist temp = p.CreatePlaylist(name);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getEmail(), getPassword());
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
