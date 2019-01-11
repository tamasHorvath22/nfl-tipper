package com.codecool.manager;

import com.codecool.model.League;

import java.util.List;
import java.util.Set;

public interface LeaugeManagerInterface {

    League findLeagueById(Long id);

    League createLeague(League league);

    List<League> findAllLeagues();

    List<League> findLeaguesByIds(List<Long> leagueIdList);

    List<Long> findLeagueIdsForUser(Long userId);
}
