package org.youcode.magestic_cup.team.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;
import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.Team;

@Mapper(componentModel = "spring")
public interface CreateTeamDTOToTeamDocumentMapper extends BaseMapper<Team , CreateTeamDTO> {
}
