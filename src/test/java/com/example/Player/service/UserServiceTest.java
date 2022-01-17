package com.example.Player.service;

import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.dto.UserDTO;
import com.example.Player.model.User;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    IUserDAL dal;
    UserService userService;
    AutoCloseable autoCloseable;
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(dal);
        modelMapper = new ModelMapper();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void findById() {
        User user = new User("Dobri","dobri@gmail.com","123");
        userService.saveOrUpdate(user);
        dal.SaveAndFlush(user);

        userService.findById(1L);
        verify(dal).findById(1L);
    }

    @Test
    void getUserByUsername() {
        User user = new User("Dobri","dobri@gmail.com","123");
        userService.saveOrUpdate(user);
        dal.SaveAndFlush(user);

        userService.getUserByUsername(user.getUsername());
        verify(dal).getUserByUsername(user.getUsername());

    }

    @Test
    @Disabled
    void getByUsernameDTO() {
    }

    @Test
    void findUserByEmail() {
        User user = new User("Dobri","dobri@gmail.com","123");
        userService.saveOrUpdate(user);
        dal.SaveAndFlush(user);

        userService.findUserByEmail(user.getEmail());
        verify(dal).findUserByEmail(user.getEmail());
    }

    @Test
    void saveOrUpdate() {
        User user = new User("Dobri","dobri@gmail.com","123");
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
        User user = new User("Dobri","dobri@gmail.com","123");
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