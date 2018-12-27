package com.codecool.repository;

import com.codecool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    public boolean existsUserByUsername(String username);

    public String getPasswordByUsername(String username);

    public User findByUsername(String username);

}
