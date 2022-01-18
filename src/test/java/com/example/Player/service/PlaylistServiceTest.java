package com.example.Player.service;

import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.model.Playlist;
import com.example.Player.model.Role;
import com.example.Player.model.User;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {PlaylistService.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class PlaylistServiceTest {
    @MockBean
    private IPlaylistDAL dal;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private PlaylistService playlistService;

    @Test
    void getById() {
        Playlist playlist = new Playlist("Cool Playlist");
        playlistService.saveAndFlush(playlist);
        dal.saveAndFlush(playlist);

        playlistService.getById(1L);
        verify(dal).getById(1L);
    }

    @Test
    void saveAndFlush() {
        Playlist playlist = new Playlist("Cool Playlist");
        playlistService.saveAndFlush(playlist);

        ArgumentCaptor<Playlist> argumentCaptor = ArgumentCaptor.forClass(Playlist.class);
        verify(dal).saveAndFlush(argumentCaptor.capture());
        Playlist captorValue = argumentCaptor.getValue();

        AssertionsForClassTypes.assertThat(captorValue).isEqualTo(playlist);
    }

    @Test
    void testGetAllByUser() {
        when(this.dal.getAllByUser((User) any())).thenReturn(new ArrayList<>());

        Role role = new Role(1L,"USER",(new HashSet<>()));
        User user = new User(1L,"Dobri","dobri@gmail.com","123",role,(new ArrayList<>()));

        assertTrue(this.playlistService.getAllByUser(user).isEmpty());
        verify(this.dal).getAllByUser((User) any());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.dal).deleteById((Long) any());
        assertEquals("{\"message\":\"Playlist has been deleted successfully\"}", this.playlistService.deleteById(123L));
        verify(this.dal).deleteById((Long) any());
    }
}

