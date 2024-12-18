package org.youcode.magestic_cup.user.interfaces;

import org.youcode.magestic_cup.user.DTOs.CreateUserDTO;
import org.youcode.magestic_cup.user.DTOs.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(CreateUserDTO data);
}
