package kbo.whoareya.player.repository;

import kbo.whoareya.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT p FROM Player p join fetch p.team t join fetch p.playerType pt ORDER BY RAND() LIMIT 1")
    Player findPlayerByRandom();

    @Query(value = "select p from Player p join fetch p.team t join fetch p.playerType pt where p.id = :id")
    Optional<Player> findPlayerById(@Param("id") Long id);

    @Query(value = "select p from Player p join fetch p.team where p.name like '%' || :name || '%'")
    List<Player> findByName(@Param("name") String name);
}
