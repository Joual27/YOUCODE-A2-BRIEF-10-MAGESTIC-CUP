package org.youcode.magestic_cup.competition.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.youcode.magestic_cup.round.DTOs.EmbeddedRoundDTO;
import org.youcode.magestic_cup.team.DTOs.EmbeddedTeamDTO;

import java.util.List;

public record CompetitionResponseDTO (String id , String name , int numberOfTeams , int currentRound , @JsonInclude(JsonInclude.Include.NON_NULL) List<EmbeddedTeamDTO> teams ,@JsonInclude(JsonInclude.Include.NON_NULL)  List<EmbeddedRoundDTO> rounds) {
}
