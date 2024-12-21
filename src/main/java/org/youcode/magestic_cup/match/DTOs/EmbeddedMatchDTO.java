package org.youcode.magestic_cup.match.DTOs;

import org.youcode.magestic_cup.match.Match;
import org.youcode.magestic_cup.team.DTOs.EmbeddedTeamDTO;

public record EmbeddedMatchDTO(EmbeddedTeamDTO home, EmbeddedMatchDTO away , Match.Result result , EmbeddedTeamDTO winner ) {
}
