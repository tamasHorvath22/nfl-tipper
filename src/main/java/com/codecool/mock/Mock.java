package com.codecool.mock;

import com.codecool.manager.LeaugeManagerInterface;
import com.codecool.manager.UserManagerInterface;
import com.codecool.model.League;
import com.codecool.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mock {

    @Autowired
    UserManagerInterface userManager;

    @Autowired
    LeaugeManagerInterface leagueManager;

    public void createUsers() {
        User user = new User("Tom", "111111", "em@ail.com");
        User user2 = new User("Jerry", "111111", "em_2@ail.com");

        League league = new League("my_league");
        league.setPrivate(true);
        league.setCreator(user);

        League league2 = new League("other_league");
        league2.setPrivate(false);
        league2.setCreator(user);

        userManager.createUser(user);
        userManager.createUser(user2);

        leagueManager.createLeague(league);
        leagueManager.createLeague(league2);

        user.addToLeagueList(league);
        user.addToLeagueList(league2);

        userManager.createUser(user);

    }
}
