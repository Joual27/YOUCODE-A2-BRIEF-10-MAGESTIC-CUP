package org.youcode.magestic_cup.team.interfaces;

import org.youcode.magestic_cup.player.DTOs.CreatePlayerDTO;
import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;

import java.util.List;

public interface TeamService {

    TeamResponseDTO save(CreateTeamDTO data);
    TeamResponseDTO addTeamPlayers( String teamId , List<CreatePlayerDTO> players);
}
