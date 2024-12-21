package org.youcode.magestic_cup.round.DTOs;

import org.youcode.magestic_cup.match.DTOs.EmbeddedMatchDTO;

import java.util.List;

public record EmbeddedRoundDTO(int roundNumber , List<EmbeddedMatchDTO> matches) {
}
