package com.codecool.service;

import com.codecool.model.League;
import com.codecool.model.User;
import com.codecool.repository.LeagueRepository;
import com.codecool.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class UserServiceTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private LeagueRepository leagueRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private LeagueService leagueService;
//
//    @Before
//    public void setUp() throws Exception {
//        User user = new User("q", "q", "q");
//        League league = new League("eee");
//        League league2 = new League("www");
//
//        userService.save(user);
//        leagueService.save(league);
//        leagueService.save(league2);
//    }
//
//    @After
//    public void tearDown() {
//        userRepository.deleteAll();
//        leagueRepository.deleteAll();
//    }
//
//    @Test
//    @Transactional
//    public void save() {
//
//        User user = userService.getUserByUsername("q");
//        League league = leagueRepository.findAll().get(0);
//        League league2 = leagueRepository.findAll().get(1);

//        user.addToLeagueList(league);
//        userService.save(user);
//        user.addToLeagueList(league2);
//        userService.save(user);
//    }
//}