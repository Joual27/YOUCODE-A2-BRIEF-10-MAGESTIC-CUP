package org.youcode.magestic_cup.competition.interfaces;

import org.youcode.magestic_cup.competition.DTOs.CompetitionResponseDTO;
import org.youcode.magestic_cup.competition.DTOs.CreateCompetitionDTO;
import org.youcode.magestic_cup.round.Round;

import java.util.List;

public interface CompetitionService {
    CompetitionResponseDTO save(CreateCompetitionDTO data);
    List<Round> getAllRoundsByCompetitionId(String competitionId);
}
