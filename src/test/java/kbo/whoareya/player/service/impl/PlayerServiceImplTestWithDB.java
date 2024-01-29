package kbo.whoareya.player.service.impl;

import kbo.whoareya.player.dto.RandomPlayer;
import kbo.whoareya.player.dto.UserPlayerResultDto;
import kbo.whoareya.player.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PlayerServiceImplTestWithDB {

    @Autowired
    PlayerService playerService;
    @Test
    void findRandomPlayer() throws Exception {
        //given

        //when
        for (int i=0; i < 10; i++) {
            RandomPlayer randomPlayer = playerService.findRandomPlayer();
            System.out.println(randomPlayer);
        }
        //then

    }

    @Test
    void compareUserSubmittedPlayerAndRandomPlayerTest() throws Exception {
        //given
        RandomPlayer randomPlayer = playerService.findRandomPlayer();
        //when
        UserPlayerResultDto dto = playerService.compareUserSubmittedPlayerAndRandomPlayer(3L, randomPlayer.getId());
        //UserPlayerResultDto dto2 = playerService.compareUserSubmittedPlayerAndRandomPlayer(4L, randomPlayer.getId());
        //then
        System.out.println(dto);
       // System.out.println(dto2);
    }


}