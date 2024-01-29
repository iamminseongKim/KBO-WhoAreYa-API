package kbo.whoareya.player.controller;

import kbo.whoareya.player.dto.PlayerInfoDto;
import kbo.whoareya.player.dto.ResponseDto;
import kbo.whoareya.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

    private final PlayerService playerService;


    @GetMapping("/api/v1/random-player")
    public PlayerInfoDto getRandomPlayer() {
        return playerService.findRandomPlayer();
    }

    @GetMapping("/api/v2/random-player")
    public ResponseDto<Object> getRandomPlayerWithStatus() {
        return ResponseDto.builder()
                .status(200)
                .message("랜덤 선수 조회 성공.")
                .data(playerService.findRandomPlayer())
                .build();
    }


    @GetMapping("/api/v1/submit/{randomId}/{userPlayerId}/{tryCount}")
    public ResponseDto<Object> submitQuiz(@PathVariable("randomId") Long randomId,
                                          @PathVariable("userPlayerId") Long userPlayerId,
                                          @PathVariable("tryCount") int tryCount) throws Exception {

        if (tryCount >= 8) {
            return ResponseDto.builder()
                    .status(200)
                    .message("기회 X")
                    .data(playerService.findPlayerById(randomId))
                    .build();
        }

        return ResponseDto.builder()
                .status(200)
                .message("응답 성공")
                .data(playerService.compareUserSubmittedPlayerAndRandomPlayer(userPlayerId, randomId))
                .build();
    }
        


}
