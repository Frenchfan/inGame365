package com.example.ingame365.web.mappers;

import com.example.ingame365.domain.entities.team.Team;
import com.example.ingame365.web.dto.team.TeamDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDto toDto(Team team);
    List<TeamDto> toDto(List<Team> teams);

    Team toEntity(TeamDto dto);
}
