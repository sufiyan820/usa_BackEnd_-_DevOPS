package com.NextLevel.USA.CONTROLLERS;

import com.NextLevel.USA.DTO0.Response.UserResponseDTO;
import com.NextLevel.USA.DTO0.request.o.User.UserRegisterDTO;
import com.NextLevel.USA.DTO0.request.o.User.UserUpdateDTO;
import com.NextLevel.USA.ENTITIES.User;
import com.NextLevel.USA.SERVICESimpl.UserService;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private  final UserService userService;

    public  UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/register")
    public ResponseEntity<User> registerUSer(
            @RequestBody
            UserRegisterDTO dto

            ) {
        return  ResponseEntity.ok(
                userService.register(dto)
        );
    }

    @PutMapping("/{id}/update")
    public  ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody
            UserUpdateDTO dto
    ) {

        User updated = userService.userUpdate(id, dto);
        return ResponseEntity.ok(userService.toDTO(updated));

    }


    @PutMapping("/{id}updatePassword")
    public ResponseEntity<UserResponseDTO> updatePassword(
            @PathVariable Long id, @RequestBody UserUpdateDTO dto) {
        User updated = userService.userUpdate(id, dto);
        return ResponseEntity.ok(userService.toDTO(updated));

    }
}
