package com.codecool.service;

import com.codecool.model.League;
import com.codecool.model.User;
import com.codecool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getOne(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean isUserRegistered(String username) {
        return userRepository.existsUserByUsername(username);
    }

    public String getPasswordByUsername(String username) {
        return userRepository.getPasswordByUsername(username);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Set<League> getUserLeagues(String username) {
        User user = userRepository.findByUsername(username);
        return user.getLeagueList();
    }
}
