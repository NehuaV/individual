package com.example.Player.service.Interfaces;

import com.example.Player.model.Role;

import java.util.Collection;
import java.util.Optional;

public interface IRoleService {
    Role findRoleByName(String name);
    Collection<Role> findAll();
    Optional<Role> findById(Long id);
}
