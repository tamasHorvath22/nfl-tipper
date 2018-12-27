package com.codecool.dto;

public class JoinToLeagueDTO {

    private Long userId;
    private Long leagueId;

    public JoinToLeagueDTO(Long userId, Long leagueId) {
        this.userId = userId;
        this.leagueId = leagueId;
    }

    public JoinToLeagueDTO() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
}
