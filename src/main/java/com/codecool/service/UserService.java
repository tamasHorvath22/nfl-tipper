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
            return UserMapper.toDto(usermanager.createUser(user));
        } catch(DataIntegrityViolationException e) {
            throw decideErrorCode(findConstraint(e.getMostSpecificCause().getMessage()));
        }
    }

    private TipperException decideErrorCode(String constraint) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if(errorCode.getConstraint().equals(constraint)) {
                return new TipperException(errorCode.toString());
            }
        }
        return new TipperException();
    }

    private String findConstraint(String source) {
        int startIndex = 0;
        int endIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < source.length(); i++) {
            if(source.charAt(i) == '"' && isFirst) {
                startIndex = i + 1;
                isFirst = false;
            } else if(source.charAt(i) == '"' && !isFirst) {
                endIndex = i;
                break;
            }
        }
        return source.substring(startIndex, endIndex);
    }

    @PostMapping(path = "/login", headers="Accept=application/json")
    public UserDTO login(@RequestBody UserDTO userDTO) throws TipperException {
        User user = usermanager.findUserByUsername(userDTO.getUsername());
        if(user == null || !passwordEncoder().matches(userDTO.getPassword(), user.getPassword())) {
            throw new TipperException(ErrorCode.WRONG_USERNAME_OR_PASSWORD.toString());
        }
        return UserMapper.toDto(user);
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
