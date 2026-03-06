package com.NextLevel.USA.CONTROLLERS;

import com.NextLevel.USA.DTO0.Response.AdminResponseDTO;
import com.NextLevel.USA.DTO0.request.o.AdminRegisterDTO;
import com.NextLevel.USA.Services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // ✅ REGISTER ADMIN
    @PostMapping("/register")
    public ResponseEntity<AdminResponseDTO> registerAdmin(
            @RequestBody AdminRegisterDTO dto
    ) {
        return ResponseEntity.ok(adminService.register(dto));
    }

    // ✅ GET ALL ADMINS
    @GetMapping
    public ResponseEntity<List<AdminResponseDTO>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    // ✅ GET ADMIN BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getById(id));
    }

    // ✅ UPDATE ADMIN
    @PutMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> updateAdmin(
            @PathVariable Long id,
            @RequestBody AdminRegisterDTO dto
    ) {
        return ResponseEntity.ok(adminService.update(id, dto));
    }

    // ✅ DELETE ADMIN
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.delete(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }
}
