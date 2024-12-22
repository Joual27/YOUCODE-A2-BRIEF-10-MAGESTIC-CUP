package org.youcode.magestic_cup.match.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.magestic_cup.match.DTOs.CreateMatchDTO;
import org.youcode.magestic_cup.match.Match;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;

@Mapper(componentModel = "Spring")
public interface CreateMatchDTOToMatchDocumentMapper extends BaseMapper<Match , CreateMatchDTO> {
    @Override
    @Mapping(target = "round.id" , source = "roundId")
    @Mapping(target = "home.id" , source = "homeId")
    @Mapping(target = "away.id" , source = "awayId")
    Match toDocument(CreateMatchDTO createMatchDTO);
}
