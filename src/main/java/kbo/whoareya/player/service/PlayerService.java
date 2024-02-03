package kbo.whoareya.player.service;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.dto.NameSearchPlayerDto;
import kbo.whoareya.player.dto.PlayerInfoDto;
import kbo.whoareya.player.dto.UserPlayerResultDto;
import kbo.whoareya.player.entity.Player;

import java.util.List;

public interface PlayerService {
    Player save(CreatePlayerDto dto);
    PlayerInfoDto findPlayerById(Long playerId);

    PlayerInfoDto findRandomPlayer();

    UserPlayerResultDto compareUserSubmittedPlayerAndRandomPlayer(Long userPlayerId, Long randomPlayerId) throws Exception;

    List<NameSearchPlayerDto> findPlayerForName(String name);
}
