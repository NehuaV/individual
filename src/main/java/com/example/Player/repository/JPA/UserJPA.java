package com.example.Player.repository.JPA;

import com.example.Player.dalinterfaces.IUserDAL;
import com.example.Player.model.User;
import com.example.Player.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class UserJPA implements IUserDAL {

    @Autowired
    IUserRepo repo;

    @Override
    public User findUserByUsername(String username){return repo.findUserByUsername(username);}

    @Override
    public User findUserByEmail(String email) {
        return repo.findUserByEmail(email);
    }

    @Override
    public User SaveAndFlush(User user) {
        return repo.saveAndFlush(user);
    }

    @Override
    public Collection<User> findAll(){ return repo.findAll();}

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }
}
