package org.youcode.magestic_cup.round.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.match.mappers.MatchDocumentToEmbeddedMatchDTOMapper;
import org.youcode.magestic_cup.round.DTOs.EmbeddedRoundDTO;
import org.youcode.magestic_cup.round.Round;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;

@Mapper(componentModel = "spring" , uses = MatchDocumentToEmbeddedMatchDTOMapper.class )
public interface RoundDocumentToEmbeddedRoundDTOMapper extends BaseMapper<Round , EmbeddedRoundDTO> {
}
