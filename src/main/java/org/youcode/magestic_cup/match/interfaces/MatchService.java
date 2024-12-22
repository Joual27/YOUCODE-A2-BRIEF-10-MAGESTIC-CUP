package org.youcode.magestic_cup.match.interfaces;

import org.youcode.magestic_cup.match.DTOs.CreateMatchDTO;
import org.youcode.magestic_cup.match.DTOs.MatchResponseDTO;
import org.youcode.magestic_cup.match.Match;

import java.util.List;

public interface MatchService {
    MatchResponseDTO save(CreateMatchDTO data);
    List<Match> getMatchesByRoundId(String roundId);
}
