package org.youcode.magestic_cup.team.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.youcode.magestic_cup.player.DTOs.EmbeddedPlayerDTO;

import java.util.List;

public record TeamResponseDTO(String id , String name , String city , @JsonInclude(JsonInclude.Include.NON_NULL) List<EmbeddedPlayerDTO> players) {
}
