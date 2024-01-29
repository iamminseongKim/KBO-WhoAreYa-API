package kbo.whoareya.player.service;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.dto.RandomPlayer;
import kbo.whoareya.player.dto.UserPlayerResultDto;
import kbo.whoareya.player.entity.Player;

import java.util.Optional;

public interface PlayerService {
    Player save(CreatePlayerDto dto);
    Optional<Player> findPlayerById(Long playerId);

    RandomPlayer findRandomPlayer();

    UserPlayerResultDto compareUserSubmittedPlayerAndRandomPlayer(Long userPlayerId, Long randomPlayerId) throws Exception;
}
