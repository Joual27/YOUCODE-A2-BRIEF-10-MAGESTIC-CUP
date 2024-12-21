package org.youcode.magestic_cup.player.interfaces;

import org.youcode.magestic_cup.player.DTOs.CreatePlayerDTO;
import org.youcode.magestic_cup.player.Player;

public interface PlayerService {
    Player save(CreatePlayerDTO data);
}
