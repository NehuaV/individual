package com.example.Player.service;

import com.example.Player.dalinterfaces.IRoleDAL;
import com.example.Player.model.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {RoleService.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class RoleServiceTest {
    @MockBean
    private IRoleDAL dal;

    @Autowired
    private RoleService roleService;

    @Test
    void testFindRoleByName() {
        Role role = new Role(1L, "USER", (new HashSet<>()));
        dal.saveAndFlush(role);

        roleService.findRoleByName(role.getName());
        verify(dal).findRoleByName(role.getName());
    }

    @Test
    void testFindAll() {
        roleService.findAll();
        verify(dal).findAll();
    }

    @Test
    void testFindById() {
        Role role = new Role(1L, "USER", (new HashSet<>()));
        dal.saveAndFlush(role);

        roleService.findById(role.getId());
        verify(dal).findById(role.getId());
    }
}

