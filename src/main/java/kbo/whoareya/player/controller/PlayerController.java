package kbo.whoareya.player.controller;

import kbo.whoareya.player.dto.PlayerInfoDto;
import kbo.whoareya.player.dto.ResponseDto;
import kbo.whoareya.player.service.PlayerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerService playerService;


    /**
     * 첫 페이지 접속 시 랜덤한 선수 한명을 조회한다.
     * */
    @GetMapping("/api/v1/random-player")
    public PlayerInfoDto getRandomPlayer() {
        return playerService.findRandomPlayer();
    }

    /**
     * v2 - status 와 메세지 추가
     * */
    @GetMapping("/api/v2/random-player")
    public ResponseDto<Object> getRandomPlayerWithStatus() {
        return ResponseDto.builder()
                .status(200)
                .message("랜덤 선수 조회 성공.")
                .data(playerService.findRandomPlayer())
                .build();
    }


    /**
     * 사용자가 정답을 제출하면 결과를 알려주는 컨트롤러
     * */
    @GetMapping("/api/v2/submit/{randomId}/{userPlayerId}/{tryCount}")
    public ResponseDto<Object> submitQuiz(@PathVariable("randomId") Long randomId,
                                          @PathVariable("userPlayerId") Long userPlayerId,
                                          @PathVariable("tryCount") int tryCount) throws Exception {

        if (tryCount > 8) {
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
        
    /**
     * 자동완성 - 사용자가 이름을 입력하면 정보를 전달하는 컨트롤러
     * */
    @GetMapping("/api/v2/autocomplete/{name}")
    public ResponseDto<Object> autocompletePlayer(@PathVariable("name") String name) {
        return ResponseDto.builder()
                .status(200)
                .message("응답 성공")
                .data(playerService.findPlayerForName(name))
                .build();
    }

}
