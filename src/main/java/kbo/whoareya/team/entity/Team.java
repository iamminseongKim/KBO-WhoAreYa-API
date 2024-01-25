package kbo.whoareya.team.entity;

import jakarta.persistence.*;
import kbo.whoareya.team.dto.CreateTeamDto;
import kbo.whoareya.player.entity.Player;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private int id;

    @Column(name = "team_name")
    private String name;

    @OneToOne(mappedBy = "team")
    private Player player;

    public static Team createTeam(CreateTeamDto dto) {
        Team team = new Team();
        team.name = dto.getName();
        return team;
    }

}
