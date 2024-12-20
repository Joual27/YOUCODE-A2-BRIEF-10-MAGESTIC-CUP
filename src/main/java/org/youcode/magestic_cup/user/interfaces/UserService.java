package org.youcode.magestic_cup.user.interfaces;

import org.youcode.magestic_cup.user.DTOs.AuthDTO;
import org.youcode.magestic_cup.user.DTOs.UserResponseDTO;

public interface UserService {
    UserResponseDTO register(AuthDTO data);
    UserResponseDTO authenticate();
}
