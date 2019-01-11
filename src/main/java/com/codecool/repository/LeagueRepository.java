package com.codecool.repository;

import com.codecool.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Long> {

    @Query(value = "SELECT league_list_id FROM users_league_list WHERE member_list_id = 1",
           nativeQuery = true)
    List<Long> findLeaguesForUser(Long userId);


//    @Query("SELECT l.league_list_id FROM users_leauge_list l WHERE l.member_list_id := userId")

}
