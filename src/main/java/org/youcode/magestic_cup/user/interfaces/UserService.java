package org.youcode.magestic_cup.user.interfaces;

import org.youcode.magestic_cup.user.DTOs.AuthDTO;
import org.youcode.magestic_cup.user.DTOs.UserResponseDTO;
import org.youcode.magestic_cup.user.User;

public interface UserService {
    UserResponseDTO register(AuthDTO credentials);
    UserResponseDTO authenticate(AuthDTO credentials);
    User getUserEntityByUsername(String username);
}
