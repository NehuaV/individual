package com.example.Player.dalinterfaces;

import com.example.Player.model.Role;

import java.util.Collection;
import java.util.Optional;

public interface IRoleDAL {
    Role getRoleByName(String name);
    Role saveAndFlush(Role role);
    Role findRoleByName(String name);
    Optional<Role> findById(Long id);
    Collection<Role> findAll();

}
