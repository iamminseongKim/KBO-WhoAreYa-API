package kbo.whoareya.player.service.impl;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.dto.ReturnRandomPlayerDto;
import kbo.whoareya.player.entity.Player;
import kbo.whoareya.player.repository.PlayerRepository;
import kbo.whoareya.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    @Override
    @Transactional
    public Player save(CreatePlayerDto dto) {
        Player player = Player.CreatePlayer(dto);
        return playerRepository.save(player);
    }

    @Override
    public Optional<Player> findPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public ReturnRandomPlayerDto findRandomPlayer() {

        return new ReturnRandomPlayerDto(playerRepository.findPlayerByRandom());
    }
}
