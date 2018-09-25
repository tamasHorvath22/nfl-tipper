package com.codecool.controller;

import com.codecool.model.League;
import com.codecool.model.User;
import com.codecool.service.LeagueService;
import com.codecool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class IndexController extends AbstractController {

    @Autowired
    UserService userService;

    @GetMapping({"", "/index"})
    public String displayIndexPage(Model model) {
        HttpSession session = getHttpSession();
        if(session.getAttribute("loggedInUser") != null) {
            User user = (User) session.getAttribute("loggedInUser");
            Set<League> userLeagueList = userService.getUserLeagues(user.getUsername());
            model.addAttribute("userLeagues", userLeagueList);
            return "index";
        }
        return "redirect:/login";
    }

}
