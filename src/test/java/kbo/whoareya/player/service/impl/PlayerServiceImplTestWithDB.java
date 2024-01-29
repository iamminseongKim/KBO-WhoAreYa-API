package kbo.whoareya.player.service.impl;

import kbo.whoareya.player.dto.ReturnRandomPlayerDto;
import kbo.whoareya.player.entity.Player;
import kbo.whoareya.player.service.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PlayerServiceImplTestWithDB {

    @Autowired
    PlayerService playerService;
    @Test
    public void findRandomPlayer() throws Exception {
        //given

        //when
        for (int i=0; i < 10; i++) {
            ReturnRandomPlayerDto randomPlayer = playerService.findRandomPlayer();
            System.out.println(randomPlayer);
        }


        //then


    }

}