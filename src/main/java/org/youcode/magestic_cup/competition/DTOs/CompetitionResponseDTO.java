package org.youcode.magestic_cup.competition.DTOs;

import org.youcode.magestic_cup.round.DTOs.EmbeddedRoundDTO;
import org.youcode.magestic_cup.team.DTOs.EmbeddedTeamDTO;

import java.util.List;

public record CompetitionResponseDTO (String id , String name , int numberOfTeams , int currentRound , List<EmbeddedTeamDTO> teams , List<EmbeddedRoundDTO> rounds) {
}
