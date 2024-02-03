package kbo.whoareya.player.service.impl;

import kbo.whoareya.player.dto.PlayerInfoDto;
import kbo.whoareya.player.dto.UserPlayerResultDto;
import kbo.whoareya.player.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Sql("/insert.sql")
class PlayerServiceImplTestWithDB {

    @Autowired
    PlayerService playerService;
    @Test
    void findRandomPlayer() throws Exception {
        //given

        //when
        for (int i=0; i < 10; i++) {
            PlayerInfoDto playerInfoDto = playerService.findRandomPlayer();
            System.out.println(playerInfoDto);
        }
        //then

    }

    @Test
    @DisplayName("랜덤선수 하나 찍어보기")
    void compareUserSubmittedPlayerAndRandomPlayerTest() throws Exception {
        //given
        PlayerInfoDto playerInfoDto = playerService.findRandomPlayer();
        //when
        UserPlayerResultDto dto = playerService.compareUserSubmittedPlayerAndRandomPlayer(3L, playerInfoDto.getId());
        //UserPlayerResultDto dto2 = playerService.compareUserSubmittedPlayerAndRandomPlayer(4L, randomPlayer.getId());
        //then
        System.out.println(dto);
       // System.out.println(dto2);
    }

    @Test
    @DisplayName("같은 선수이면 결과가 true 인지 체크")
    void compareUserSubmittedPlayerTest() throws Exception {
        //given
        PlayerInfoDto playerInfoDto = playerService.findRandomPlayer();
        //when
        UserPlayerResultDto dto = playerService.compareUserSubmittedPlayerAndRandomPlayer(3L, 3L);
        //UserPlayerResultDto dto2 = playerService.compareUserSubmittedPlayerAndRandomPlayer(4L, randomPlayer.getId());
        //then
       assertThat(dto.isResult()).isEqualTo(true);
    }

}