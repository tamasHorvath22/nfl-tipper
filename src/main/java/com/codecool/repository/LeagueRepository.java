package com.codecool.repository;

import com.codecool.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Integer> {

    public League findById(int id);
}
