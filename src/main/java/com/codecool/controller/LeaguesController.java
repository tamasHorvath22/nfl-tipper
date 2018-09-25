package com.codecool.controller;

import com.codecool.model.League;
import com.codecool.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LeaguesController extends AbstractController {

    @Autowired
    LeagueService leagueService;

    @GetMapping("/leagues")
    public String displayLeagues(Model model) {
        HttpSession session = getHttpSession();
        if(session.getAttribute("loggedInUser") != null) {
            List<League> leagueList = leagueService.findAll();
            model.addAttribute("leagueList", leagueList);
            return "leagues";
        }
        return "redirect:/login";
    }
}
