package org.youcode.magestic_cup.user.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;
import org.youcode.magestic_cup.user.DTOs.UserResponseDTO;
import org.youcode.magestic_cup.user.User;

@Mapper
public interface UserDocumentToUserResponseDTOMapper extends BaseMapper<User, UserResponseDTO> {
}
