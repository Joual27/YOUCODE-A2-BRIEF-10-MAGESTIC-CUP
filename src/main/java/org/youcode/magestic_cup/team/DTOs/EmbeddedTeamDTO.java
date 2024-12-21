package org.youcode.magestic_cup.team.DTOs;

import org.youcode.magestic_cup.player.DTOs.EmbeddedPlayerDTO;

import java.util.List;

public record EmbeddedTeamDTO(String name, String city , List<EmbeddedPlayerDTO> players) {
}
