package kbo.whoareya.team.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CreateTeamDto {
    private String name;
}
