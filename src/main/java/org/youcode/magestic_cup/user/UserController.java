package org.youcode.magestic_cup.user;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.magestic_cup.shared.utils.DTOs.SuccessDTO;
import org.youcode.magestic_cup.user.DTOs.CreateUserDTO;
import org.youcode.magestic_cup.user.DTOs.UserResponseDTO;
import org.youcode.magestic_cup.user.interfaces.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/public")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<SuccessDTO<UserResponseDTO>> register(@RequestBody @Valid CreateUserDTO req){
        UserResponseDTO res = userService.register(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "User registered successfully " , res) , HttpStatus.OK);
    }
}
