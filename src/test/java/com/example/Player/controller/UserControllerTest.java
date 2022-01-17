package com.example.Player.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.Player.model.Role;
import com.example.Player.model.User;
import com.example.Player.security.JwtToken.JwtProvider;
import com.example.Player.service.Interfaces.IPlaylistService;
import com.example.Player.service.Interfaces.IRoleService;
import com.example.Player.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private IPlaylistService iPlaylistService;

    @MockBean
    private IRoleService iRoleService;

    @MockBean
    private IUserService iUserService;

    @MockBean
    private JwtProvider jwtProvider;

    @Autowired
    private UserController userController;

    @Test
    void testAuthenticate() throws Exception {
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        Role role = new Role(1L, "USER", (new HashSet<>()));
        User user = new User(1L, "Dobri", "dobri@gmail.com", "123", role, (new ArrayList<>()));

        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testAuthenticate2() throws Exception {
        when(this.jwtProvider.createToken((String) any(), (Role) any())).thenReturn("ABC123");

        Role role = new Role(1L, "USER", (new HashSet<>()));
        User user = new User(1L, "Dobri", "dobri@gmail.com", "123", role, (new ArrayList<>()));

        when(this.iUserService.getUserByUsername((String) any())).thenReturn(user);

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        when(this.authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new RunAsUserToken("?", "Principal", "Credentials", authorities, Authentication.class));


        String content = (new ObjectMapper()).writeValueAsString(user);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"username\":\"Principal\",\"authorities\":[],\"token\":\"ABC123\"}"));
    }

    @Test
    void testRegister() throws Exception {
        Role role = new Role(1L, "USER", (new HashSet<>()));
        User user = new User(1L, "Dobri", "dobri@gmail.com", "123", role, (new ArrayList<>()));

        when(this.iUserService.saveOrUpdate((User) any())).thenReturn(user);
        when(this.iRoleService.findRoleByName((String) any())).thenReturn(role);

        String content = (new ObjectMapper()).writeValueAsString(user);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Dobri saved successfully\"}"));
    }
}

