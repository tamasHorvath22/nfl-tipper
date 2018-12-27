package com.codecool.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class League {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @Column
    private Boolean isPrivate;

    @Override
    public String toString() {
        return "id: " + this.id + " name: " + this.name + " creator: " + this.creator;
    }

    @ManyToMany(mappedBy = "leagueList")
    private Set<User> memberList = new HashSet<>();

    public League(String name) {
        this.name = name;
    }

    public League(Long id, Long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public League() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Set<User> getMemberList() {
        return memberList;
    }
}
