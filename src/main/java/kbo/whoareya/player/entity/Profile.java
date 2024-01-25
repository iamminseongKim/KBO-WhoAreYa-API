package kbo.whoareya.player.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

/*
@Entity
@Getter @Setter
public class Profile {

    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    private String filePath;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "player_id")
    private Player player;


    public static Profile createProfile(String filePath, Player player) {
        Profile profile = new Profile();
        profile.player = player;
        profile.filePath = filePath;
        return profile;
    }
}
*/
