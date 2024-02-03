package kbo.whoareya.player.controller;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.dto.PlayerInfoDto;
import kbo.whoareya.player.dto.UserPlayerResultDto;
import kbo.whoareya.player.entity.Player;
import kbo.whoareya.player.entity.PlayerType;
import kbo.whoareya.player.entity.Position;
import kbo.whoareya.player.service.PlayerService;
import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.team.entity.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    PlayerService playerService;
    static PlayerInfoDto playerInfoDto;

    // 랜덤 선수 만들기
    @BeforeAll
    static void randomSetUp(){
        CreateTeamDto teamDto = new CreateTeamDto("SSG 랜더스");
        Team team = Team.createTeam(teamDto);

        PlayerType type = new PlayerType(1, "좌투좌타");

        CreatePlayerDto dto = CreatePlayerDto.builder()
                .type(type)
                .team(team)
                .position(Position.P)
                .birthDate(LocalDate.of(1997, 7, 25))
                .backNumber(99)
                .height(176)
                .name("김민성")
                .build();

        playerInfoDto = new PlayerInfoDto(Player.CreatePlayer(dto));
        playerInfoDto.setId(1L);
    }

    @Test
    @DisplayName("첫 페이지 선수 조회 api")
    void getRandomPlayerTest() throws Exception {
        //given
        given(playerService.findRandomPlayer()).willReturn(playerInfoDto);

        //when

        //then
        mvc.perform(get("/api/v2/random-player"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    @DisplayName("문제제출 - 기회가 남았고 랜덤선수와 제출 값이 일치 하지 않을 때")
    void submitQuizTestWhenNotExceedTryAndFail() throws Exception {
        //given

        UserPlayerResultDto userPlayerResultDto = UserPlayerResultDto.builder()
                .result(false)
                .playerName("김깐득")
                .build();

        given(playerService.compareUserSubmittedPlayerAndRandomPlayer(2L, 1L)).willReturn(userPlayerResultDto);
        //when
        
        //then
        mvc.perform(get("/api/v2/submit/1/2/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.data.result").value("false"));

    }

    @Test
    @DisplayName("문제제출 - 기회가 남지않았을 때")
    void submitQuizTestWhenExceedTryAndFail() throws Exception {
        //given


        given(playerService.findPlayerById(anyLong())).willReturn(playerInfoDto);
        //when

        //then
        mvc.perform(get("/api/v2/submit/1/2/9"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.message").value("기회 X"))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("김민성"));
    }


    @Test
    @DisplayName("문제제출 - 정답일 때")
    void submitQuizTestWhenCorrect() throws Exception {
        //given
        UserPlayerResultDto userPlayerResultDto = UserPlayerResultDto.builder()
                .result(true)
                .playerName("김민성")
                .build();
        given(playerService.compareUserSubmittedPlayerAndRandomPlayer(1L, 1L)).willReturn(userPlayerResultDto);
        //when

        //then
        mvc.perform(get("/api/v2/submit/1/1/2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.message").value("응답 성공"))
                .andExpect(jsonPath("$.data.result").value("true"))
                .andExpect(jsonPath("$.data.playerName").value("김민성"));
    }

    @Test
    @DisplayName("플레이어 이름검색")
    void searchPlayerForName() throws Exception {
        //given

        //when

        //then
    }

}