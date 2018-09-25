package com.codecool.repository;

import com.codecool.model.League;
import com.codecool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public boolean existsUserByUsername(String username);

    public String getPasswordByUsername(String username);

    public User findByUsername(String username);

}
