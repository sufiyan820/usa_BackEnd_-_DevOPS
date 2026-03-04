package com.NextLevel.USA.CONTROLLERS;

import com.NextLevel.USA.DTO0.request.o.AdminRegisterDTO;
import com.NextLevel.USA.DTO0.request.o.User.UserRegisterDTO;
import com.NextLevel.USA.SERVICESimpl.UserService;
import com.NextLevel.USA.Services.AdminService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AdminService adminService;
    private final UserService userService;

    public AuthController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    // Admin login hai bhiya
    @PostMapping("/login/admin")
    public ResponseEntity<String> loginAdmin(@RequestBody AdminRegisterDTO dto) {
        String token = adminService.login(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok(token);
    }

    // User login hai bhaiya ++++++++`
    @PostMapping("/login/user")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserRegisterDTO dto) {

        String token = userService.login(dto.getEmail(), dto.getPassword());

        return ResponseEntity.ok(Map.of("token",token));
    }
}
