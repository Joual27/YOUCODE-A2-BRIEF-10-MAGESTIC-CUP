package org.youcode.magestic_cup.user.DTOs;

import org.youcode.magestic_cup.role.DTOs.EmbeddedRoleDTO;

import java.util.List;

public record UserResponseDTO(String id , String token , List<EmbeddedRoleDTO> roles) {
}
