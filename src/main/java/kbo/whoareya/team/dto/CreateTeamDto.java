package kbo.whoareya.team.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateTeamDto {
    private String name;

    public CreateTeamDto(String name) {
        this.name = name;
    }
}
