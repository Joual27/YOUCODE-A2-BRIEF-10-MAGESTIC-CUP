package org.youcode.magestic_cup.role.mappers;

import org.mapstruct.Mapper;
import org.youcode.magestic_cup.role.DTOs.EmbeddedRoleDTO;
import org.youcode.magestic_cup.role.Role;
import org.youcode.magestic_cup.shared.utils.interfaces.BaseMapper;

@Mapper
public interface RoleEntityToEmbeddedRoleDTOMapper extends BaseMapper<Role , EmbeddedRoleDTO> {
}
