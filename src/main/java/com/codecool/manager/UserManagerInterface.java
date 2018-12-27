package com.codecool.manager;

import com.codecool.model.User;

import java.util.List;

public interface UserManagerInterface {

    User findUserById(Long id);

    User findUserByUsername(String username);

    User createUser(User user);

    List<User> findAllUsers();

}
