package kbo.whoareya.player.entity;

import jakarta.persistence.*;
import kbo.whoareya.player.dto.CreatePlayerDto;
import kbo.whoareya.team.entity.Team;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id; // 고유 아이디

    private String name;    // 이름
    private LocalDate birthDate;    // 생년월일
    private int backNumber; // 등번호
    @Enumerated(STRING)
    private PlayerType playerType; // LEFT / RIGHT (왼손/오른손)

    private int height; // 키

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")// 팀 : 선수 1 : N
    private Team team;

   /* @OneToOne(mappedBy = "player")
    private Profile profile;*/

    @Enumerated(STRING)
    private Position position;

    public static int setAge(Player player) {
        return calculateAge(player.getBirthDate());
    }

    private static int calculateAge(LocalDate birthDay) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthDay, today);
        return period.getYears();
    }

    public static String setPosition(Position position) {
        if (position.equals(Position.P))
            return "투수";
        if (position.equals(Position.IF))
            return "내야수";
        if (position.equals(Position.OF))
            return "외야수";
        if (position.equals(Position.C))
            return "포수";

        return null;
    }

    public static Player CreatePlayer(CreatePlayerDto dto) {
        Player player = new Player();
        player.name = dto.getName();
        player.position = dto.getPosition();
        player.birthDate = dto.getBirthDate();
        player.height = dto.getHeight();
        player.team = dto.getTeam();
        player.playerType = dto.getType();
        player.backNumber = dto.getBackNumber();
        return player;
    }




}
