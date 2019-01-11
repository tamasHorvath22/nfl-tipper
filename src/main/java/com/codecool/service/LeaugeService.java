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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        user.addToLeagueList(league);
        LeagueDTO dtoToReturn = LeagueMapper.toDto(leaugeManager.createLeague(league));
        userManager.createUser(user);
        return dtoToReturn;
    }

    @PostMapping(path = "/join-league", headers = "Accept=application/json")
    public void joinLeague(@RequestBody JoinToLeagueDTO joinToLeagueDTO) {
        League league = leaugeManager.findLeagueById(joinToLeagueDTO.getLeagueId());
        User user = userManager.findUserById(joinToLeagueDTO.getUserId());
        user.addToLeagueList(league);
        userManager.createUser(user);
    }

    @GetMapping(path = "/get-leagues/{userId}")
    public List<LeagueDTO> getLeagues(@PathVariable("userId") Long userId) {
        List<Long> leagueIdList = leaugeManager.findLeagueIdsForUser(userId);
        List<Long> x = new ArrayList<Long>();
        for (int i = 0; i < leagueIdList.size(); i++) {
//            System.out.println(leagueIdList.get(i).longValue());
            x.add(leagueIdList.get(i).longValue());
        }
        List<League> leagueList = leaugeManager.findLeaguesByIds(x);
        List<LeagueDTO> leagueDTOList = new ArrayList<>();
        for (League league: leagueList) {
            leagueDTOList.add(LeagueMapper.toDto(league));
        }
        return leagueDTOList;
    }
}
