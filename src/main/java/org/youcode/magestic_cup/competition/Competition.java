package org.youcode.magestic_cup.competition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.round.Round;
import org.youcode.magestic_cup.team.Team;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "competitions")
public class Competition {
    @Id
    private String id;
    private String name;
    private int numberOfTeams;
    @DBRef
    private List<Team> teams;
    private int currentRound;
    @DBRef
    private List<Round> rounds;

}
