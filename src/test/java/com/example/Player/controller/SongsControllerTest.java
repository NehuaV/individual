package com.example.Player.controller;

import static org.mockito.Mockito.when;

import com.example.Player.service.Interfaces.IPlaylistService;
import com.example.Player.service.Interfaces.ISongService;
import com.example.Player.service.Interfaces.IUserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {SongsController.class})
@ExtendWith(SpringExtension.class)
class SongsControllerTest {
    @MockBean
    private IPlaylistService iPlaylistService;

    @MockBean
    private ISongService iSongService;

    @MockBean
    private IUserService iUserService;

    @Autowired
    private SongsController songsController;

    @Test
    void testGetAllSongs() throws Exception {
        when(this.iSongService.getAllSongs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/song/songs");
        MockMvcBuilders.standaloneSetup(this.songsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testRemoveSong() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/song");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("songId", String.valueOf(1L));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.songsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

