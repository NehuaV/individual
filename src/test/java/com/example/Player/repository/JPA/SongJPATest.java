package com.example.Player.repository.JPA;

import com.example.Player.model.Playlist;
import com.example.Player.model.Song;
import com.example.Player.repository.ISongRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class SongJPATest {

    @Mock
    ISongRepo repo;
    SongJPA songJPA;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        songJPA = new SongJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllSongs() {
        songJPA.GetAllSongs();

        verify(repo).findAll();
    }

    @Test
    void getSongByTitle() {
        // Set up
        Song song = new Song("title","artist","http://link.com");
        songJPA.saveAndFlush(song);
        repo.save(song);

        songJPA.getSongByTitle(song.getTitle());
        verify(repo).findSongByTitle(song.getTitle());
    }

    @Test
    void saveAndFlush() {
        Song song = new Song("title","artist","http://link.com");

        songJPA.saveAndFlush(song);

        ArgumentCaptor<Song> argumentCaptor = ArgumentCaptor.forClass(Song.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        Song captorValue = argumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(song);
    }

    @Test
    void deleteSong() {
        Song song = new Song("title","artist","http://link.com");
        long id = 1;
        given(repo.getById(id))
                .willReturn(song);

        songJPA.deleteSong(song);

        verify(repo).delete(song);
    }

    @Test
    void deleteById() {
        Song song = new Song("title","artist","http://link.com");
        long id = 1;
        given(repo.getById(id))
                .willReturn(song);

        songJPA.deleteById(id);

        verify(repo).deleteById(id);
    }

    @Test
    void getAllByPlaylist() {
        Playlist playlist = new Playlist("Cool Playlist");
        Song song = new Song("title","artist","http://link.com");
        List<Song> songs = new ArrayList<>(){{add(song);}};
        given(repo.findAllByPlaylist(playlist))
                .willReturn(songs);

        songJPA.GetAllByPlaylist(playlist);

        verify(repo).findAllByPlaylist(playlist);
    }
}