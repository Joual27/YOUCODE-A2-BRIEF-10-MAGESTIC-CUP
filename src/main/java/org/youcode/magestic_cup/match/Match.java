package org.youcode.magestic_cup.match;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.stats.Stats;
import org.youcode.magestic_cup.team.Team;

import java.util.List;

@Document(collection = "matches")
public class Match {
    @Id
    private String id;
    private int round;
    @DBRef
    private Team home;
    @DBRef
    private Team away;
    private Result result;

    @DBRef
    private Team winner;


    public static class Result {
        private int homeGoals;
        private int awayGoals;

        @DBRef
        private List<Stats> statistics;

    }
}