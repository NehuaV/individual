package com.example.Player.repository.JPA;

import com.example.Player.model.Role;
import com.example.Player.repository.IRoleRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class RoleJPATest {

    @Mock
    IRoleRepo repo;
    RoleJPA roleJPA;
    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        roleJPA = new RoleJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void findAll() {
        roleJPA.findAll();

        verify(repo).findAll();
    }

    @Test
    void getRoleByName() {
        // Set up
        Role role = new Role("USER");
        roleJPA.saveAndFlush(role);
        repo.save(role);

        roleJPA.getRoleByName(role.getName());
        verify(repo).findRoleByName(role.getName());
    }

    @Test
    void saveAndFlush() {
        Role role = new Role("USER");
        roleJPA.saveAndFlush(role);

        ArgumentCaptor<Role> argumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        Role captorValue = argumentCaptor.getValue();

        assertThat(captorValue).isEqualTo(role);
    }

    @Test
    void findRoleByName() {
        // Set up
        Role role = new Role("USER");
        roleJPA.saveAndFlush(role);
        repo.save(role);

        roleJPA.findRoleByName(role.getName());
        verify(repo).findRoleByName(role.getName());
    }

    @Test
    void findById() {
        // Set up
        Role role = new Role("USER");
        roleJPA.saveAndFlush(role);
        repo.save(role);

        roleJPA.findById(1L);
        verify(repo).findById(1L);
    }
}