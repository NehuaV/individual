package com.example.Player.service;

import com.example.Player.dalinterfaces.IRoleDAL;
import com.example.Player.model.Role;
import com.example.Player.service.Interfaces.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service @Transactional @Slf4j
public class RoleService implements IRoleService {

    IRoleDAL dal;
    @Autowired
    public RoleService(IRoleDAL dal) {
        this.dal = dal;
    }

    @Override
    public Role findRoleByName(String name) {
        return dal.findRoleByName(name);
    }

    @Override
    public Collection<Role> findAll() {
        return dal.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return dal.findById(id);
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return dal.saveAndFlush(role);
    }
}
