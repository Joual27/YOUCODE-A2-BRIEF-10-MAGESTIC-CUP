package org.youcode.magestic_cup.player.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.player.DTOs.CreatePlayerDTO;
import org.youcode.magestic_cup.player.Player;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;

@Mapper(componentModel = "spring")
public interface CreatePlayerDTOToPlayerDocumentMapper extends BaseMapper<Player , CreatePlayerDTO> {
}
