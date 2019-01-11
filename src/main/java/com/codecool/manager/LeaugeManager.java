package com.codecool.manager;

import com.codecool.model.League;
import com.codecool.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LeaugeManager implements LeaugeManagerInterface {

    @Autowired
    private LeagueRepository repository;

    @Override
    public League findLeagueById(Long id) { return repository.getOne(id); }

    @Override
    public League createLeague(League league) {
        return repository.save(league);
    }

    @Override
    public List<League> findAllLeagues() {
        return repository.findAll();
    }

    @Override
    public List<League> findLeaguesByIds(List<Long> leagueIdList) { return repository.findAllById(leagueIdList); }

    @Override
    public List<Long> findLeagueIdsForUser(Long userId) { return repository.findLeaguesForUser(userId); }

}
