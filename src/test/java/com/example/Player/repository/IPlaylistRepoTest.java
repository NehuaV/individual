package com.example.Player.repository;

import com.example.Player.model.Playlist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IPlaylistRepoTest {

    @Autowired
    IPlaylistRepo repo;

    @AfterEach
    void tearDown() {
        repo.deleteAll();
    }

    @Test
    void findPlaylistByName() {
        Playlist playlist = new Playlist("Cool playlist");
        repo.save(playlist);
        Playlist actual = repo.findPlaylistByName(playlist.getName());
        assertThat(actual).isEqualTo(playlist);
    }

    @Test
    void getById() {
        Playlist playlist = new Playlist("Cool playlist");
        repo.save(playlist);
        Playlist actual = repo.getById(playlist.getId());
        assertThat(actual).isEqualTo(playlist);
    }

    @Test
    @Disabled
    void getByUserAndId() {

    }

    @Test
    @Disabled
    void getAllByUser() {
    }
}