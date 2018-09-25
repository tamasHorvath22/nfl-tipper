package com.codecool.service;

import com.codecool.model.League;
import com.codecool.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeagueService {

    @Autowired
    LeagueRepository leagueRepository;

    public List<League> findAll() {
        return leagueRepository.findAll();
    }

    public void save(League league) {
        leagueRepository.save(league);
    }

    public League findById(int id) {
        return leagueRepository.findById(id);
    }
}
