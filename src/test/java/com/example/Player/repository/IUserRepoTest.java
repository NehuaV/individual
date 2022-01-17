package com.example.Player.repository;

import com.example.Player.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class IUserRepoTest {

    @Autowired
    IUserRepo repo;

    @AfterEach
    void tearDown() {
        repo.deleteAll();
    }

    @Test
    void getUserByUsername() {
        User expected = new User("Dobri","dobri@gmail.com","123");
        repo.save(expected);

        User actual = repo.getUserByUsername(expected.getUsername());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findUserByEmail() {
        User expected = new User("Dobri","dobri@gmail.com","123");
        repo.save(expected);

        User actual = repo.findUserByEmail(expected.getEmail());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void deleteById() {
        User user = new User("Dobri","dobri@gmail.com","123");
        repo.save(user);
        repo.deleteById(user.getId());
        User actual = repo.getUserByUsername(user.getUsername());

        assertThat(actual).isEqualTo(null);
    }
}