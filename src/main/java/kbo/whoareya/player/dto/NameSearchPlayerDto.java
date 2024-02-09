package kbo.whoareya.player.dto;

import kbo.whoareya.player.entity.Player;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NameSearchPlayerDto {

    private final Long playerId;
    private final String playerName;
    private final String teamName;
    private final int teamId;
    private final LocalDate birtDate;


    public NameSearchPlayerDto(Player player) {
        this.playerId = player.getId();
        this.playerName = player.getName();
        this.teamName = player.getTeam().getName();
        this.teamId = player.getTeam().getId();
        this.birtDate = player.getBirthDate();
    }


}
