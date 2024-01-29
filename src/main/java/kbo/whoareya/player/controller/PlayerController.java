package kbo.whoareya.player.controller;

import kbo.whoareya.player.dto.RandomPlayer;
import kbo.whoareya.player.dto.ResponseDto;
import kbo.whoareya.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

    private final PlayerService playerService;


    @GetMapping("/api/v1/random-player")
    public RandomPlayer getRandomPlayer() {
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

        


}
