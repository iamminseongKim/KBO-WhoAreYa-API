package kbo.whoareya.player.dto;

import kbo.whoareya.player.entity.Player;
import kbo.whoareya.player.entity.PlayerType;
import kbo.whoareya.player.entity.Position;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter
public class ReturnRandomPlayerDto {

    private Long id;
    private String name;
    private String teamName;
    private int backNumber;
    private String position;
    private PlayerType type;
    private int height;
    private int age;



    public ReturnRandomPlayerDto(Player player) {
        this.id = player.getId();
        this.backNumber = player.getBackNumber();
        this.teamName = player.getTeam().getName();
        this.position = setPosition(player.getPosition());
        this.type = player.getPlayerType();
        this.height = player.getHeight();
        this.age = setAge(player);
        this.name = player.getName();
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


    public static int setAge(Player player) {
        return calculateAge(player.getBirthDate());
    }

    private static int calculateAge(LocalDate birthDay) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthDay, today);
        return period.getYears();
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
