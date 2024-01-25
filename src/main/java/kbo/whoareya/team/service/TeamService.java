package kbo.whoareya.team.service;

import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.team.entity.Team;

import java.util.Optional;

public interface TeamService {
    Team save(CreateTeamDto dto);
    Optional<Team> findTeam(int teamId);
}
