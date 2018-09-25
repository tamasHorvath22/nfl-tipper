package com.codecool.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class League {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "leagueList")
    private Set<User> memberList = new HashSet<>();

    public League(String name) {
        this.name = name;
    }

    public League() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getMemberList() {
        return memberList;
    }
}
