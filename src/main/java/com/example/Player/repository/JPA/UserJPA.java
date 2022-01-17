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

    IUserRepo repo;

    @Autowired
    public UserJPA(IUserRepo repo) {
        this.repo = repo;
    }

    @Override
    public User getUserByUsername(String username){return repo.getUserByUsername(username);}

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
