package kbo.whoareya.player.dto;

import kbo.whoareya.player.entity.Player;
import kbo.whoareya.player.entity.PlayerType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayerInfoDto {

    private Long id;
    private String name;
    private String teamName;
    private int backNumber;
    private String position;
    private String type;
    private int height;
    private int age;



    public PlayerInfoDto(Player player) {
        this.id = player.getId();
        this.backNumber = player.getBackNumber();
        this.teamName = player.getTeam().getName();
        this.position = Player.setPosition(player.getPosition());
        this.type = player.getPlayerType().getName();
        this.height = player.getHeight();
        this.age = Player.setAge(player);
        this.name = player.getName();
    }

    @Override
    public String toString() {
        return "랜덤선수 정보는 {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", backNumber=" + backNumber +
                ", position='" + position + '\'' +
                ", type=" + type +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
