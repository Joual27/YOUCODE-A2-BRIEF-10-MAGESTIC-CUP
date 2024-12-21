package org.youcode.magestic_cup.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.player.Player;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String city;

    @DBRef
    private List<Player> players;
}