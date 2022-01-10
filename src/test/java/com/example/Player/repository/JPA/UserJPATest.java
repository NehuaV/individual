package com.example.Player.repository.JPA;

import com.example.Player.dalinterfaces.IUserDAL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserJPATest {

    @Autowired
    IUserDAL dal;

    @Test
    void saveAndFlush() {
    }

    @Test
    void getUserByUsername() {

    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {
    }
}