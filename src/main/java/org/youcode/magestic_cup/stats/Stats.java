package org.youcode.magestic_cup.stats;

import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.youcode.magestic_cup.player.Player;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "statistics")
public class Stats {
    @Id
    private String id;
    @DBRef
    private Player player;
    private int goals;
    private int assists;
    @Max(1)
    private int yellowCards;
    @Max(1)
    private int redCards;

}