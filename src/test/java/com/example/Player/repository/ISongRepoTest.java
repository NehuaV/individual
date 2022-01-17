package com.example.Player.repository;

import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ISongRepoTest {

    @Autowired
    ISongRepo repo;

    @AfterEach
    void tearDown() {
        repo.deleteAll();
    }

    @Test
    void findSongByTitle() {
        Song song = new Song("title","artist","https://link.com");
        repo.save(song);
        Song actual = repo.findSongByTitle(song.getTitle());
        assertThat(actual).isEqualTo(song);
    }

    @Test
    @Disabled
    void findAllByPlaylist() {
        Playlist playlist = new Playlist("Cool Playlist");
        Song song1 = new Song(1L,"title1","artist1","https://link1.com", playlist);
        Song song2 = new Song(2L,"title2","artist2","https://link2.com", playlist);
        Song song3 = new Song(3L,"title3","artist3","https://link3.com", playlist);
        List<Song> expected = new ArrayList<>(){{
            add(song1);
            add(song2);
            add(song3);
        }};
        repo.save(song1);
        repo.save(song2);
        repo.save(song3);

        List<Song> actual = repo.findAllByPlaylist(playlist);

        assertThat(expected).isEqualTo(actual);
    }
}