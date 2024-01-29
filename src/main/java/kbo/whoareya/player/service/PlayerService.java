package kbo.whoareya.player.service;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.dto.PlayerInfoDto;
import kbo.whoareya.player.dto.UserPlayerResultDto;
import kbo.whoareya.player.entity.Player;

public interface PlayerService {
    Player save(CreatePlayerDto dto);
    PlayerInfoDto findPlayerById(Long playerId);

    PlayerInfoDto findRandomPlayer();

    UserPlayerResultDto compareUserSubmittedPlayerAndRandomPlayer(Long userPlayerId, Long randomPlayerId) throws Exception;
}
