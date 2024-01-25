package kbo.whoareya.player.entity;

import jakarta.persistence.*;
import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.team.entity.Team;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Player {

    @Id @GeneratedValue
    @Column(name = "player_id")
    private Long id; // 고유 아이디

    private String name;    // 이름
    private LocalDate birthDate;    // 생년월일

    @Enumerated(STRING)
    private PlayerType playerType; // LEFT / RIGHT (왼손/오른손)

    private int height; // 키

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

   /* @OneToOne(mappedBy = "player")
    private Profile profile;*/

    @Enumerated(STRING)
    private Position position;

    public static Player CreatePlayer(CreatePlayerDto dto) {
        Player player = new Player();
        player.name = dto.getName();
        player.position = dto.getPosition();
        player.birthDate = dto.getBirthDate();
        player.height = dto.getHeight();
        player.team = dto.getTeam();
        player.playerType = dto.getType();
        return player;
    }




}
