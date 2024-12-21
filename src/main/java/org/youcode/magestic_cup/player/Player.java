package org.youcode.magestic_cup.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "PLAYERS")
public class Player {
    @Id
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;
}