package com.codecool.service;

import com.codecool.common.ErrorCode;
import com.codecool.common.UserMapper;
import com.codecool.dto.UserDTO;
import com.codecool.exception.TipperException;
import com.codecool.manager.UserManagerInterface;
import com.codecool.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserService {

    @Autowired
    private UserManagerInterface usermanager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @GetMapping
//    public User getUser(@PathVariable int id) {
//        return usermanager.findUserById(id);
//    }

    @GetMapping
    public User getUser(@PathVariable String username) {
        return usermanager.findUserByUsername(username);
    }

    @PostMapping(path = "/register", headers="Accept=application/json")
    public UserDTO register(@RequestBody UserDTO userDTO) throws TipperException {
        try {
            User user = UserMapper.toEntity(userDTO);
            user.setPassword(passwordEncoder().encode(userDTO.getPassword()));
            User userr = usermanager.createUser(user);
            return UserMapper.toDto(userr);
        } catch(DataIntegrityViolationException e) {
            String cucc = e.getMostSpecificCause().getMessage();

            TipperException ex = new TipperException(ErrorCode.USER_ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS.toString());
            throw ex;
        }
    }

    @PostMapping(path = "/login", headers="Accept=application/json")
    public UserDTO login(@RequestBody UserDTO userDTO) throws Exception {
        User user;
        try {
            user = usermanager.findUserByUsername(userDTO.getUsername());
            if(passwordEncoder().matches(user.getPassword(), userDTO.getPassword())) {
                return UserMapper.toDto(user);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(int id) {
//        return userRepository.getOne(id);
//    }
//
//    public void save(User user) {
//        userRepository.save(user);
//    }
//
//    public boolean isUserRegistered(String username) {
//        return userRepository.existsUserByUsername(username);
//    }
//
//    public String getPasswordByUsername(String username) {
//        return userRepository.getPasswordByUsername(username);
//    }
//
//    public User getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

//    public Set<League> getUserLeagues(String username) {
//        User user = userRepository.findByUsername(username);
//        return user.getLeagueList();
//    }
}
