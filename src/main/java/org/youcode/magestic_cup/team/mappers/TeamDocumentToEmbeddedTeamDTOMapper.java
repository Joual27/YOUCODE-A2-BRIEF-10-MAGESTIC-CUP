package org.youcode.magestic_cup.team.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;
import org.youcode.magestic_cup.team.DTOs.EmbeddedTeamDTO;
import org.youcode.magestic_cup.team.Team;

@Mapper(componentModel = "spring")
public interface TeamDocumentToEmbeddedTeamDTOMapper extends BaseMapper<Team , EmbeddedTeamDTO> {
}
