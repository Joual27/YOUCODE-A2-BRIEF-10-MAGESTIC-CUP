package org.youcode.magestic_cup.user.mappers;

import
org.mapstruct.Mapper;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;
import org.youcode.magestic_cup.user.DTOs.AuthDTO;
import org.youcode.magestic_cup.user.User;

@Mapper(componentModel = "spring")
public interface CreateUserDTOToUserDocumentMapper extends BaseMapper<User , AuthDTO> {
}
