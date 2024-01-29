package kbo.whoareya.player.service.impl;

import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.player.dto.RandomPlayer;
import kbo.whoareya.player.dto.UserPlayerResultDto;
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
    public RandomPlayer findRandomPlayer() {
        return new RandomPlayer(playerRepository.findPlayerByRandom());
    }

    @Override
    public UserPlayerResultDto compareUserSubmittedPlayerAndRandomPlayer(Long userPlayerId, Long randomPlayerId) throws Exception{

        // 1. id 서로 일치 시 → 정답

        // 2. id 서로 불일치 시 → 값 비교
        Optional<Player> userPlayerOpt = playerRepository.findById(userPlayerId);
        Player userPlayer;
        if (userPlayerOpt.isPresent())
            userPlayer = userPlayerOpt.get();
        else
            throw new IllegalStateException("사용자가 제출한 선수의 id 가 조회 불가");

        Optional<Player> randomPlayerOpt = playerRepository.findById(randomPlayerId);

        Player randomPlayer;
        if (randomPlayerOpt.isPresent())
            randomPlayer = randomPlayerOpt.get();
        else
            throw new IllegalStateException("랜덤 선수의 id 가 조회 불가");


        return comparePlayer(userPlayer, randomPlayer);
    }

    private UserPlayerResultDto comparePlayer(Player userPlayer, Player randomPlayer) {

        return UserPlayerResultDto.builder()
                .playerName(userPlayer.getName())
                .teamName(userPlayer.getTeam().getName())
                .teamCorrect(userPlayer.getTeam() == randomPlayer.getTeam())
                .age(Player.setAge(userPlayer))
                .ageDiff(Player.setAge(userPlayer) - Player.setAge(randomPlayer))
                .backNumber(userPlayer.getBackNumber())
                .backNumberDiff(userPlayer.getBackNumber() - randomPlayer.getBackNumber())
                .height(userPlayer.getHeight())
                .heightDiff(userPlayer.getHeight() - randomPlayer.getHeight())
                .handType(String.valueOf(userPlayer.getPlayerType()))
                .handTypeCorrect(userPlayer.getPlayerType() == randomPlayer.getPlayerType())
                .position(Player.setPosition(userPlayer.getPosition()))
                .positionCorrect(userPlayer.getPosition() == randomPlayer.getPosition())
                .build();
    }
}
