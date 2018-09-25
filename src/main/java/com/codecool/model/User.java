package com.codecool.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    private Set<League> leagueList = new HashSet<>();

    public User(String username, String firstName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.password = password;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public Set<League> getLeagueList() {
        return leagueList;
    }

    public void addToLeagueList(League league) {
        leagueList.add(league);
        league.getMemberList().add(this);
    }
}
