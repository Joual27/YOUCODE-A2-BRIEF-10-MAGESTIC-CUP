package org.youcode.magestic_cup.match.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.match.DTOs.EmbeddedMatchDTO;
import org.youcode.magestic_cup.match.Match;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;

@Mapper(componentModel = "spring")
public interface MatchDocumentToEmbeddedMatchDTOMapper extends BaseMapper<Match , EmbeddedMatchDTO> {
}
