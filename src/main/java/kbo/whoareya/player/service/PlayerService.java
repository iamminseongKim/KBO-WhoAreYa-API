package kbo.whoareya.player.service;

import kbo.whoareya.player.dto.CreatePlayerDto;

public interface PlayerService {
    Long save(CreatePlayerDto dto);
}
