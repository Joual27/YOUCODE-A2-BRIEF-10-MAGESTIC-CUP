package org.youcode.magestic_cup.stats;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.player.Player;

@Document(collection = "statistics")
public class Stats {
    @Id
    private String id;
    @DBRef
    private Player player;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;

}