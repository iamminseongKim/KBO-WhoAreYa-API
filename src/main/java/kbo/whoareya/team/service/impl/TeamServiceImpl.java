package kbo.whoareya.team.service.impl;

import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.team.entity.Team;
import kbo.whoareya.team.repository.TeamRepository;
import kbo.whoareya.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Team save(CreateTeamDto dto) {
        Team team = Team.createTeam(dto);
        return teamRepository.save(team);
    }
    @Override
    public Optional<Team> findTeam(int teamId) {
        return teamRepository.findById(teamId);
    }
}
