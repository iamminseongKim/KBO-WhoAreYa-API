package kbo.whoareya.player.dto;

import kbo.whoareya.player.entity.*;
import kbo.whoareya.player.service.PlayerService;
import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.team.entity.Team;
import kbo.whoareya.team.service.TeamService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CreatePlayerDtoTest {

    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;

    @BeforeAll
    static void setUp() {

    }


    @Test
    @DisplayName("플레이어 생성 해보기")
    void makePlayer() {

        CreateTeamDto SSG = new CreateTeamDto("SSG 랜더스");
        Team team = teamService.save(SSG);

        CreatePlayerDto dto = CreatePlayerDto.builder()
                .type(PlayerType.LEFT)
                .team(team)
                .position(Position.P)
                .birthDate(LocalDate.of(1997, 7, 25))
                .backNumber(99)
                .height(176)
                .name("김민성")
                .build();

        Long saveId = playerService.save(dto).getId();

        Team findTeam = teamService.findTeam(team.getId()).get();

        assertThat(team.getName()).isEqualTo(findTeam.getName());
        assertThat(saveId).isEqualTo(1L);

    }

    @Test
    @DisplayName("플레이어 id로 찾기")
    void findByPlayerId() {
        CreateTeamDto SSG = new CreateTeamDto("SSG 랜더스");
        Team team = teamService.save(SSG);

        CreatePlayerDto dto = CreatePlayerDto.builder()
                .type(PlayerType.LEFT)
                .team(team)
                .position(Position.P)
                .birthDate(LocalDate.of(1997, 7, 25))
                .backNumber(99)
                .height(176)
                .name("김민성")
                .build();

        Player player = playerService.save(dto);
        Player findPlayer = playerService.findPlayerById(player.getId()).get();

    }
}
