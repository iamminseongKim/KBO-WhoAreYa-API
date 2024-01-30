package kbo.whoareya.player.dto;

import kbo.whoareya.team.entity.Team;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPlayerResultDto {

    private boolean result;         // 정답인가 아닌가?
    private String teamName;        // 팀명
    private boolean teamCorrect;    // 팀이 일치 한가
    private String position;        // 포지션 명
    private boolean positionCorrect;    // 포지션이 일치 한가
    private int age;                // 나이
    private String ageDiff;            // 나이 차이

    private int backNumber;         // 등번호
    private String backNumberDiff;     // 등번호 차이
    private int height;             // 키
    private String heightDiff;         // 키 차이

    private String handType;         // 타입 (왼손/오른손)
    private boolean handTypeCorrect;

    private String playerName;      // 사용자가 입력한 선수 명

    @Override
    public String toString() {
        return "UserPlayerResultDto{" +
                "teamName='" + teamName + '\'' +
                ", teamCorrect=" + teamCorrect +
                ", position='" + position + '\'' +
                ", positionCorrect=" + positionCorrect +
                ", age=" + age +
                ", ageDiff=" + ageDiff +
                ", backNumber=" + backNumber +
                ", backNumberDiff=" + backNumberDiff +
                ", height=" + height +
                ", heightDiff=" + heightDiff +
                ", handType='" + handType + '\'' +
                ", handTypeCorrect=" + handTypeCorrect +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
