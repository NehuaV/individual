package com.example.Player.service;

import com.example.Player.dalinterfaces.ISongDAL;
import com.example.Player.model.Song;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {SongService.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class SongServiceTest {

    @MockBean
    private ISongDAL dal;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private SongService songService;

    @Test
    void testDeleteById() {
        doNothing().when(this.dal).deleteById((Long) any());
        assertEquals("{\"message\":\"Song was deleted successfully\"}", this.songService.deleteById(123L));
        verify(this.dal).deleteById((Long) any());
        assertTrue(this.songService.getAllSongs().isEmpty());
    }

    @Test
    void testGetAllSongs() {
        when(this.dal.GetAllSongs()).thenReturn(new ArrayList<>());
        assertTrue(this.songService.getAllSongs().isEmpty());
        verify(this.dal).GetAllSongs();
    }

    @Test
    void getSongByTitle() {
        Song song = new Song("Title", "Artist", "https://link.com");
        songService.saveAndFlush(song);
        dal.saveAndFlush(song);

        songService.getSongByTitle(song.getTitle());
        verify(dal).getSongByTitle(song.getTitle());
    }

    @Test
    void saveAndFlush() {
        Song song = new Song("Title", "Artist", "https://link.com");
        songService.saveAndFlush(song);

        ArgumentCaptor<Song> argumentCaptor = ArgumentCaptor.forClass(Song.class);
        verify(dal).saveAndFlush(argumentCaptor.capture());
        Song captorValue = argumentCaptor.getValue();

        AssertionsForClassTypes.assertThat(captorValue).isEqualTo(song);
    }

    @Test
    void getAllSongs() {
        songService.getAllSongs();
        verify(dal).GetAllSongs();
    }
}

