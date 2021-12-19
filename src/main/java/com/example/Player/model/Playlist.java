package com.example.Player.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    @Getter
    @Setter
    private String name;

    @OneToMany(targetEntity = Song.class, mappedBy = "playlist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<Song> songs;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter private User user;
    

    public void addSong(Song song){
        songs.add(song);
    }


    public Long getId() {
        return id;
    }

    public Playlist(String name){
        this.name = name;
    }

    public Playlist() {
    }


}
