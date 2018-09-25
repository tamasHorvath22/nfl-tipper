package com.codecool.api;

import com.codecool.controller.AbstractController;
import com.codecool.model.League;
import com.codecool.model.User;
import com.codecool.service.LeagueService;
import com.codecool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


@RestController
public class JoinLeagues extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private LeagueService leagueService;

    @PostMapping("/join-league")
    @Transactional
    public ResponseEntity<String> joinLeague(@RequestParam Integer leagueId) {
        HttpSession session = getHttpSession();
        League league = leagueService.findById(leagueId);
        User user = (User) session.getAttribute("loggedInUser");
        user = userService.getUserById(user.getId());
        user.addToLeagueList(league);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
