package kbo.whoareya.player.repository;

import kbo.whoareya.player.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Sql("/insert.sql")
class PlayerRepositoryTest {

    @Autowired PlayerRepository playerRepository;

    @Test
    @DisplayName("이름검색 쿼리")
    void findByNameContainingTest() throws Exception {
        //given
        String name = "에";
        //when
        List<Player> byNameContaining = playerRepository.findByName(name);
        //then

        for (Player player : byNameContaining) {
            System.out.println(player.getName());
            System.out.println(player.getTeam().getName());
        }

    }
}