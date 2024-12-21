package org.youcode.magestic_cup.competition.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.competition.Competition;
import org.youcode.magestic_cup.competition.DTOs.CompetitionResponseDTO;
import org.youcode.magestic_cup.round.mappers.RoundDocumentToEmbeddedRoundDTOMapper;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;

@Mapper(componentModel = "spring" , uses = RoundDocumentToEmbeddedRoundDTOMapper.class)
public interface CompetitionDocumentToCompetitionResponseDTOMapper extends BaseMapper<Competition , CompetitionResponseDTO> {
}
