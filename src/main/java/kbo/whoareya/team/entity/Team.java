package kbo.whoareya.team.entity;

import jakarta.persistence.*;
import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.player.entity.Player;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;

    @Column(name = "team_name")
    private String name;

    // 단방향만 사용하겠음.
    //private List<Player> playerList = new ArrayList<>();

    public static Team createTeam(CreateTeamDto dto) {
        Team team = new Team();
        team.name = dto.getName();
        return team;
    }

}
