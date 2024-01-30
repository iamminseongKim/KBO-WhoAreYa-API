package kbo.whoareya.player.service.impl;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.entity.Player;
import kbo.whoareya.player.entity.PlayerType;
import kbo.whoareya.player.entity.Position;
import kbo.whoareya.player.repository.PlayerRepository;
import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.team.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {

    @Mock
    PlayerRepository playerRepository;

    @InjectMocks
    PlayerServiceImpl playerService;


    @Test
    void saveTest() throws Exception {
        //given
        CreateTeamDto teamDto = new CreateTeamDto("SSG 랜더스");
        Team team = Team.createTeam(teamDto);

        CreatePlayerDto dto = CreatePlayerDto.builder()
                .name("김민성")                                            // 이름
                .team(team)                                               // 팀 객체
                //.type(PlayerType.LEFT)                                    // 왼손
                .backNumber(1)                                            // 등번호
                .height(176)                                              // 키
                .birthDate(LocalDate.of(1997,7,25)) // 생년월일
                .position(Position.P)                                     // 포지션 투수
                .build();                                                 // dto 생성

        Player player = Player.CreatePlayer(dto);

        given(playerRepository.save(any())).willReturn(player);

        //when
        Player savePlayer = playerService.save(dto);
        //then
        assertThat(savePlayer.getId()).isEqualTo(player.getId());
    }


}