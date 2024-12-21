package org.youcode.magestic_cup.round.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.youcode.magestic_cup.match.DTOs.EmbeddedMatchDTO;

import java.util.List;

public record EmbeddedRoundDTO(int roundNumber , @JsonInclude(JsonInclude.Include.NON_NULL) List<EmbeddedMatchDTO> matches) {
}
