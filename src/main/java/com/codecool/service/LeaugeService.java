package com.codecool.service;

import com.codecool.common.LeagueMapper;
import com.codecool.dto.JoinToLeagueDTO;
import com.codecool.dto.LeagueDTO;
import com.codecool.exception.TipperException;
import com.codecool.manager.LeaugeManagerInterface;
import com.codecool.manager.UserManagerInterface;
import com.codecool.model.League;
import com.codecool.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaugeService {

    @Autowired
    LeaugeManagerInterface leaugeManager;

    @Autowired
    UserManagerInterface userManager;

    @PostMapping(path = "/create-league", headers = "Accept=application/json")
    public LeagueDTO createLeague(@RequestBody LeagueDTO leagueDTO) throws TipperException {
        User user = userManager.findUserById(leagueDTO.getCreator().getId());
        League league = LeagueMapper.toEntity(leagueDTO);
        league.setCreator(user);
        return LeagueMapper.toDto(leaugeManager.createLeague(league));
    }

    @PostMapping(path = "/join-league", headers = "Accept=application/json")
    public void joinLeague(@RequestBody JoinToLeagueDTO joinToLeagueDTO) {
        League league = leaugeManager.findLeaugeById(joinToLeagueDTO.getLeagueId());
        User user = userManager.findUserById(joinToLeagueDTO.getUserId());
//        league.addUserToMemberList(user);
        user.addToLeagueList(league);
//        leaugeManager.createLeague(league);
        userManager.createUser(user);
        System.out.println(user);
    }
}
