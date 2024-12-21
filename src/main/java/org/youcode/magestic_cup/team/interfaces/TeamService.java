package org.youcode.magestic_cup.team.interfaces;

import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;

public interface TeamService {

    TeamResponseDTO save(CreateTeamDTO data);
}
