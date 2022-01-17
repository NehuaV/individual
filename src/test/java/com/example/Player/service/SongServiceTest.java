package com.example.Player.service;

import com.example.Player.dalinterfaces.ISongDAL;
import com.example.Player.dalinterfaces.IUserDAL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SongServiceTest {

    @Mock
    ISongDAL dal;
    SongService service;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        service = new SongService(dal);
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getSongByTitle() {
    }

    @Test
    void getAllByPlaylist() {
    }

    @Test
    void saveAndFlush() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getAllByPlaylistDTO() {
    }

    @Test
    void getAllSongs() {
    }
}