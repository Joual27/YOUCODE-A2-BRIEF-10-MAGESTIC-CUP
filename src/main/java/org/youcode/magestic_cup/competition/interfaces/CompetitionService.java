package org.youcode.magestic_cup.competition.interfaces;

import org.youcode.magestic_cup.competition.DTOs.CompetitionResponseDTO;
import org.youcode.magestic_cup.competition.DTOs.CreateCompetitionDTO;

public interface CompetitionService {
    CompetitionResponseDTO save(CreateCompetitionDTO data);
}
