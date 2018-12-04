package com.codecool.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "users_username_unique", columnNames = "username"),
        @UniqueConstraint(name = "users_email_unique", columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

//    @ManyToMany
//    private Set<League> leagueList = new HashSet<>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {}

    public Long getId() {
        return this.id;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setLeagueList(Set<League> leagueList) {
//        this.leagueList = leagueList;
//    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


//    public Set<League> getLeagueList() {
//        return leagueList;
//    }
//
//    public void addToLeagueList(League league) {
//        leagueList.add(league);
//        league.getMemberList().add(this);
//    }
}
