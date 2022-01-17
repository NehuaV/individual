package com.example.Player.repository;

import com.example.Player.model.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class IRoleRepoTest {

    @Autowired
    IRoleRepo repo;

    @AfterEach
    void tearDown() {
        repo.deleteAll();
    }

    @Test
    void findRoleByName() {
        Role role = new Role("USER");
        repo.save(role);
        Role actual = repo.findRoleByName(role.getName());
        assertThat(actual).isEqualTo(role);
    }
}