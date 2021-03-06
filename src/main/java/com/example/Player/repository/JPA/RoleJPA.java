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

    IRoleRepo repo;

    @Autowired
    public RoleJPA(IRoleRepo repo) {
        this.repo = repo;
    }

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
        return repo.findById(id);
    }

    @Override
    public Collection<Role> findAll() {
        return repo.findAll();
    }
}
