package org.youcode.magestic_cup.stats.interfaces;

import org.youcode.magestic_cup.stats.Stats;

import java.util.List;

public interface StatsService {
    List<Stats> getPlayerStatsPreviousToRound(String playerId , String roundId);
}
