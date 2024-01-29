package kbo.whoareya.player.controller;

import kbo.whoareya.player.dto.ReturnRandomPlayerDto;
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
    public ReturnRandomPlayerDto getRandomPlayer() {
        return playerService.findRandomPlayer();
    }

}
