package com.example.Player.repository.JPA;

import com.example.Player.model.User;
import com.example.Player.repository.IUserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class UserJPATest {

    @Mock
    IUserRepo repo;
    UserJPA userJPA;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userJPA = new UserJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void findAll() {
        userJPA.findAll();

        verify(repo).findAll();
    }

    @Test
    void getUserByUsername() {
        User user = new User("Dobri","dobri@gmail.com","123");
        userJPA.SaveAndFlush(user);
        repo.save(user);

        userJPA.getUserByUsername(user.getUsername());
        verify(repo).getUserByUsername(user.getUsername());
    }

    @Test
    void findUserByEmail() {
        User user = new User("Dobri","dobri@gmail.com","123");
        userJPA.SaveAndFlush(user);
        repo.save(user);

        userJPA.findUserByEmail(user.getEmail());
        verify(repo).findUserByEmail(user.getEmail());
    }

    @Test
    void saveAndFlush() {
        // Make user
        User user = new User("Dobri","dobri@gmail.com","123");

        // Call tested class method
        userJPA.SaveAndFlush(user);

        // Capture the Object Class we pass onto our repository (repo.saveAndFlush(student);)
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        User capturedUser = argumentCaptor.getValue();

        // Make sure the Passed User is the same as the Provided one
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void deleteById() {
        User user = new User("Dobri","dobri@gmail.com","123");
        long id = 1;
        given(repo.getById(id))
                .willReturn(user);

        userJPA.deleteById(id);

        verify(repo).deleteById(id);
    }

    @Test
    void findById() {
        User user = new User("Dobri","dobri@gmail.com","123");
        userJPA.SaveAndFlush(user);
        repo.save(user);

        userJPA.findById(1L);
        verify(repo).findById(1L);
    }
}