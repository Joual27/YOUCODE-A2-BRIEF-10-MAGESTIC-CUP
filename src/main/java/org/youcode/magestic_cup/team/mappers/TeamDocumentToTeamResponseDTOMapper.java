package org.youcode.magestic_cup.team.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;
import org.youcode.magestic_cup.team.Team;

@Mapper(componentModel = "spring" , uses = )
public interface TeamDocumentToTeamResponseDTOMapper extends BaseMapper<Team, TeamResponseDTO> {
}
