package com.example.Player.repository;

import com.example.Player.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role,Long> {
    Role findRoleByName(String name);
}
