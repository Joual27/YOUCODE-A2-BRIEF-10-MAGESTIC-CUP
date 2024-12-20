package org.youcode.magestic_cup.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.exceptions.UsernameAlreadyExistsException;
import org.youcode.magestic_cup.role.DTOs.EmbeddedRoleDTO;
import org.youcode.magestic_cup.role.Role;
import org.youcode.magestic_cup.role.interfaces.RoleService;
import org.youcode.magestic_cup.shared.utils.security.JwtService;
import org.youcode.magestic_cup.user.DTOs.AuthDTO;
import org.youcode.magestic_cup.user.DTOs.UserResponseDTO;
import org.youcode.magestic_cup.user.interfaces.UserService;
import org.youcode.magestic_cup.user.mappers.CreateUserDTOToUserDocumentMapper;
import org.youcode.magestic_cup.user.mappers.UserDocumentToUserResponseDTOMapper;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserDAO userDAO;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final CreateUserDTOToUserDocumentMapper createUserDTOToUserDocumentMapper;
    private final UserDocumentToUserResponseDTOMapper userDocumentToUserResponseDTOMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO register(AuthDTO data){
        if (userDAO.findByUsername(data.username()).isPresent()){
            throw new UsernameAlreadyExistsException("This is username is already taken ! try another one !");
        }
        User userToCreate = createUserDTOToUserDocumentMapper.toDocument(data);
        userToCreate.setPassword(passwordEncoder.encode(data.password()));
        List<Role> userRoles = new ArrayList<>();
        Role defaultRole = roleService.getRoleDocumentByName("OPERATOR");
        userRoles.add(defaultRole);
        userToCreate.setRoles(userRoles);
        User createdUser = userDAO.save(userToCreate);
        String token = jwtService.generateToken(createdUser);
        List<EmbeddedRoleDTO> rolesResponse = jwtService.extractRoles(token)
                .stream().map(EmbeddedRoleDTO::new)
                .toList();
        return new UserResponseDTO(createdUser.getId() , token , rolesResponse);
    }

}
