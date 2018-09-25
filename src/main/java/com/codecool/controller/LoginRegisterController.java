package com.codecool.controller;

import com.codecool.helper.Hash;
import com.codecool.model.User;
import com.codecool.service.UserService;
import org.hibernate.HibernateError;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginRegisterController extends AbstractController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String displayLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        if(userService.isUserRegistered(username)) {
            User user = userService.getUserByUsername(username);
            if(Hash.isPasswordCorrect(password, user.getPassword())) {
                HttpSession session = getHttpSession();
                session.setAttribute("loggedInUser", user);
                return "redirect:/index";
            } else {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String displayRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam("username") String userName,
                                  @RequestParam("firstName") String firstName,
                                  @RequestParam("password") String password) {
        User user = new User(userName, firstName, Hash.hashPassword(password));
        try {
            userService.save(user);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return "redirect:/register";
        }
        return "redirect:/login";
    }
}
