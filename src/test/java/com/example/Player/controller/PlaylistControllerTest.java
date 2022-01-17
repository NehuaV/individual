package com.example.Player.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.Player.model.Role;
import com.example.Player.model.User;
import com.example.Player.service.Interfaces.IPlaylistService;
import com.example.Player.service.Interfaces.ISongService;
import com.example.Player.service.Interfaces.IUserService;

import java.util.ArrayList;
import java.util.HashSet;

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

@ContextConfiguration(classes = {PlaylistController.class})
@ExtendWith(SpringExtension.class)
class PlaylistControllerTest {
    @MockBean
    private IPlaylistService iPlaylistService;

    @MockBean
    private ISongService iSongService;

    @MockBean
    private IUserService iUserService;

    @Autowired
    private PlaylistController playlistController;

    @Test
    void testAddPlaylist() throws Exception {
        Role role = new Role(1L, "USER", (new HashSet<>()));
        User user = new User(1L, "Dobri", "dobri@gmail.com", "123", role, (new ArrayList<>()));

        when(this.iUserService.getUserByUsername((String) any())).thenReturn(user);
        when(this.iPlaylistService.getAllByUser((User) any())).thenReturn(new ArrayList<>());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/playlist")
                .param("playlistName", "foo")
                .param("userUsername", "foo");

        MockMvcBuilders.standaloneSetup(this.playlistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllUserPlaylists() throws Exception {
        Role role = new Role(1L, "USER", (new HashSet<>()));
        User user = new User(1L, "Dobri", "dobri@gmail.com", "123", role, (new ArrayList<>()));

        when(this.iUserService.getUserByUsername((String) any())).thenReturn(user);
        when(this.iPlaylistService.getAllByUser((User) any())).thenReturn(new ArrayList<>());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/playlist").param("userUsername", "foo");
        MockMvcBuilders.standaloneSetup(this.playlistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testRemovePlaylist() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/playlist");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("playlistId", String.valueOf(1L));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.playlistController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

