package com.example.Player.repository.JPA;

import com.example.Player.dalinterfaces.IRoleDAL;
import com.example.Player.model.Role;
import com.example.Player.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class RoleJPA implements IRoleDAL {
    @Autowired
    IRoleRepo repo;
    @Override
    public Role getRoleByName(String name) {
        return repo.findRoleByName(name);
    }

    @Override
    public Role saveAndFlush(Role role) {
        return repo.saveAndFlush(role);
    }

    @Override
    public Role findRoleByName(String name) {
        return repo.findRoleByName(name);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Role> findAll() {
        return null;
    }
}
