package kbo.whoareya.player.repository;

import kbo.whoareya.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT p FROM Player p join fetch p.team t join fetch p.playerType pt ORDER BY RAND() LIMIT 1")
    Player findPlayerByRandom();
}
