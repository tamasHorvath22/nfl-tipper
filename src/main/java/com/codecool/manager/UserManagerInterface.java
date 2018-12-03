package com.codecool.manager;

import com.codecool.model.User;

public interface UserManagerInterface {

    User findUserById(int id);

    User findUserByUsername(String username);

    User createUser(User user);

}
