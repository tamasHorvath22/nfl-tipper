package com.codecool.controller;

import com.codecool.model.League;
import com.codecool.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CreateLeagueController extends AbstractController {

    @Autowired
    LeagueService leagueService;

    @GetMapping("/create-league")
    public String displayCreateLeague() {
        HttpSession session = getHttpSession();
        if(session.getAttribute("loggedInUser") != null) {
            return "createLeague";
        }
        return "redirect:/login";
    }

    @PostMapping("/create-league")
    public String createNewLeague(@RequestParam("name") String leagueName) {
        HttpSession session = getHttpSession();
        if(session.getAttribute("loggedInUser") != null) {
            League league = new League(leagueName);
            leagueService.save(league);
            return "index";
        }
        return "redirect:/login";
    }
}
