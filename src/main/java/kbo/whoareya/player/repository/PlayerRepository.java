package kbo.whoareya.player.repository;

import kbo.whoareya.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "select * from player order by rand() limit 1", nativeQuery = true)
    Player findPlayerByRandom();
}
