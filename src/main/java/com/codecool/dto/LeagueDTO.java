package com.codecool.dto;

import com.codecool.model.User;

public class LeagueDTO {

    private Long id;
    private Long version;
    private String name;
    private UserDTO creator;
    private Boolean isPrivate;

    public LeagueDTO(Long id, Long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public LeagueDTO() {}

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

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
