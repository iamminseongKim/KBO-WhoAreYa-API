package kbo.whoareya.player.dto;

import kbo.whoareya.player.entity.PlayerType;
import kbo.whoareya.player.entity.Position;
import kbo.whoareya.player.entity.Profile;
import kbo.whoareya.team.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Builder
public class CreatePlayerDto {
    private String name;
    private Team team;
    private LocalDate birthDate;
    private PlayerType type;
    private Position position;
    private int height;
    private int backNumber;
    private Profile profile;
}
