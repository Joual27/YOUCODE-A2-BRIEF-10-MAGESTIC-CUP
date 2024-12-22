package org.youcode.magestic_cup.match.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.match.DTOs.MatchResponseDTO;
import org.youcode.magestic_cup.match.Match;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;


@Mapper(componentModel = "spring" , uses = {})
public interface MatchDocumentToMatchResponseDTOMapper extends BaseMapper<Match , MatchResponseDTO> {
}
