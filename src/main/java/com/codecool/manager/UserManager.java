package com.codecool.manager;

import com.codecool.model.User;
import com.codecool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager implements UserManagerInterface {

    @Autowired
    private UserRepository repository;

    @Override

    public List<User> findAllUsers() { return repository.findAll(); }

    @Override
    public User findUserById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
}
