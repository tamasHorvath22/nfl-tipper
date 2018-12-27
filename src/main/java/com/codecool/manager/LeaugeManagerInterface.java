package com.codecool.manager;

import com.codecool.model.League;

import java.util.List;

public interface LeaugeManagerInterface {

    League findLeaugeById(Long id);

    League createLeague(League league);

    List<League> findAllLeagues();
}
