package org.youcode.magestic_cup.match.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.magestic_cup.match.DTOs.MatchResponseDTO;
import org.youcode.magestic_cup.match.Match;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;
import org.youcode.magestic_cup.team.mappers.TeamDocumentToEmbeddedTeamDTOMapper;


@Mapper(componentModel = "spring" , uses = TeamDocumentToEmbeddedTeamDTOMapper.class)
public interface MatchDocumentToMatchResponseDTOMapper extends BaseMapper<Match , MatchResponseDTO> {

    @Override
    @Mapping(source = "round.roundNumber" , target = "round")
    Match toDocument(MatchResponseDTO matchResponseDTO);
}
