package org.youcode.magestic_cup.match.DTOs;

import org.youcode.magestic_cup.match.Match;
import org.youcode.magestic_cup.team.DTOs.EmbeddedTeamDTO;

public record MatchResponseDTO(String id , int round , EmbeddedTeamDTO home , EmbeddedTeamDTO away , Match.Result result , EmbeddedTeamDTO winner) {
}
