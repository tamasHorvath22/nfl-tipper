package com.codecool.manager;

import com.codecool.model.League;
import com.codecool.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaugeManager implements LeaugeManagerInterface {

    @Autowired
    private LeagueRepository repository;

    @Override
    public League findLeaugeById(Long id) { return repository.getOne(id); }

    @Override
    public League createLeague(League league) {
        return repository.save(league);
    }

    @Override
    public List<League> findAllLeagues() {
        return repository.findAll();
    }

}
