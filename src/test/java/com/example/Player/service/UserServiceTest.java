package com.example.Player.service;

import com.example.Player.dalinterfaces.IPlaylistDAL;
import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.dto.UserDTO;
import com.example.Player.model.Role;
import com.example.Player.model.User;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @MockBean
    private IPlaylistDAL iPlaylistDAL;

    @MockBean
    private IUserDAL iUserDAL;

    @MockBean
    private ModelMapper modelMapper;

    @Mock
    IUserDAL dal;
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(dal);
    }


    @Test
    void findById() {
        User user = new User("Dobri", "dobri@gmail.com", "123");
        userService.saveOrUpdate(user);
        dal.SaveAndFlush(user);

        userService.findById(1L);
        verify(dal).findById(1L);
    }

    @Test
    void getUserByUsername() {
        User user = new User("Dobri", "dobri@gmail.com", "123");
        userService.saveOrUpdate(user);
        dal.SaveAndFlush(user);

        userService.getUserByUsername(user.getUsername());
        verify(dal).getUserByUsername(user.getUsername());
    }

    @Test
    @Disabled
    void testGetByUsernameDTO() {
        Role role = new Role(1L, "USER", (new HashSet<>()));
        User user = new User(1L,"Dobri", "dobri@gmail.com", "123",role,(new ArrayList<>()));
        dal.SaveAndFlush(user);

        UserDTO userDTO = new UserDTO(1L,"Dobri","dobri@gmail.com");
        UserDTO coverted = userService.getByUsernameDTO(user.getUsername());
        AssertionsForClassTypes.assertThat(coverted).isEqualTo(userDTO);
    }


    @Test
    void findUserByEmail() {
        User user = new User("Dobri", "dobri@gmail.com", "123");
        userService.saveOrUpdate(user);
        dal.SaveAndFlush(user);

        userService.findUserByEmail(user.getEmail());
        verify(dal).findUserByEmail(user.getEmail());
    }

    @Test
    void saveOrUpdate() {
        User user = new User("Dobri", "dobri@gmail.com", "123");
        userService.saveOrUpdate(user);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(dal).SaveAndFlush(argumentCaptor.capture());
        User capturedUser = argumentCaptor.getValue();

        AssertionsForClassTypes.assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    @Disabled
    void getUserProfile() {
    }

    @Test
    void deleteById() {
        User user = new User("Dobri", "dobri@gmail.com", "123");
        dal.SaveAndFlush(user);

        String message = userService.deleteById(1L);

        assertThat(message).isEqualTo("{\"message\":\"User deleted successfully\"}");
    }

    @Test
    void findAll() {
        userService.findAll();
        verify(dal).findAll();
    }
}