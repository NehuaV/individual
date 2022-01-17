package com.example.Player.repository.JPA;

import com.example.Player.model.Playlist;
import com.example.Player.model.Role;
import com.example.Player.model.Song;
import com.example.Player.model.User;
import com.example.Player.repository.IPlaylistRepo;
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

class PlaylistJPATest {

    @Mock
    IPlaylistRepo repo;
    PlaylistJPA playlistJPA;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        playlistJPA = new PlaylistJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getById() {
        Playlist playlist = new Playlist("Cool Playlist");
        playlistJPA.saveAndFlush(playlist);
        repo.save(playlist);

        playlistJPA.getById(1L);
        verify(repo).getById(1L);
    }

    @Test
    void getPlaylistByName() {
        Playlist playlist = new Playlist("Cool Playlist");
        playlistJPA.saveAndFlush(playlist);
        repo.save(playlist);

        playlistJPA.getPlaylistByName(playlist.getName());
        verify(repo).findPlaylistByName(playlist.getName());
    }

    @Test
    void saveAndFlush() {
        Playlist playlist = new Playlist("Cool Playlist");
        playlistJPA.saveAndFlush(playlist);

        ArgumentCaptor<Playlist> argumentCaptor = ArgumentCaptor.forClass(Playlist.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        Playlist captorValue = argumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(playlist);
    }

    @Test
    void deletePlaylist() {
        Playlist playlist = new Playlist("Cool Playlist");
        long id = 1;
        given(repo.getById(id))
                .willReturn(playlist);

        playlistJPA.deletePlaylist(playlist);

        verify(repo).delete(playlist);
    }

    @Test
    void deleteById() {
        Playlist playlist = new Playlist("Cool Playlist");
        long id = 1;
        given(repo.getById(id))
                .willReturn(playlist);

        playlistJPA.deleteById(id);

        verify(repo).deleteById(id);
    }

    @Test
    void getAllByUser() {
        User user = new User("Dobri","dobri@gmail.com","123");
        Playlist playlist = new Playlist("Cool Playlist");
        List<Playlist> songs = new ArrayList<>(){{add(playlist);}};
        given(repo.getAllByUser(user))
                .willReturn(songs);

        playlistJPA.getAllByUser(user);

        verify(repo).getAllByUser(user);
    }

    @Test
    void getAllPlaylist() {
        playlistJPA.GetAllPlaylist();
        verify(repo).findAll();
    }
}