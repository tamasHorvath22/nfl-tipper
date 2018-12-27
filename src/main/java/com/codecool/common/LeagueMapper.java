package com.codecool.common;

import com.codecool.dto.LeagueDTO;
import com.codecool.model.League;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class LeagueMapper {

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static LeagueDTO toDto(League league) {
        return modelMapper().map(league, LeagueDTO.class);
    }

    public static League toEntity(LeagueDTO leagueDTO) {
        return modelMapper().map(leagueDTO, League.class);
    }

}
