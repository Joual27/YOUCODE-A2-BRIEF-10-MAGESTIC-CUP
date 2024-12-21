package org.youcode.magestic_cup.round;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.competition.Competition;
import org.youcode.magestic_cup.match.Match;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "rounds")
public class Round {
    @Id
    private String id;
    private int roundNumber;
    @DBRef
    private Competition competition;

    @DBRef
    private List<Match> matches;

}
