package com.NextLevel.USA.SERVICESimpl;

import com.NextLevel.USA.DTO0.Response.AdminResponseDTO;
import com.NextLevel.USA.DTO0.request.o.AdminRegisterDTO;
import com.NextLevel.USA.ENTITIES.Admin;
import com.NextLevel.USA.Enum.Role;
import com.NextLevel.USA.Mapper.AdminMapper;
import com.NextLevel.USA.Services.AdminService;
import com.NextLevel.USA.Util.JwtUtil;
import com.NextLevel.USA.jpAREPOSITORIES.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AdminServiceImpl(AdminRepository adminRepository,
                            PasswordEncoder passwordEncoder,
                            JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REGISTER ADMIN
    @Override
    public AdminResponseDTO register(AdminRegisterDTO dto) {

        if (adminRepository.existsByAdminEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        Admin admin = new Admin();
        admin.setAdminName(dto.getName());
        admin.setAdminEmail(dto.getEmail());
        admin.setPassword(passwordEncoder.encode(dto.getPassword()));
        admin.setRole(Role.ADMIN);

        Admin savedAdmin = adminRepository.save(admin); // ✅ SAVE TO DB

        return AdminMapper.toDTO(admin);
    }

    // ✅ LOGIN ADMIN
    @Override
    public String login(String email, String rawPassword) {

        Admin admin = adminRepository.findByAdminEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(rawPassword, admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // ✅ Use injected jwtUtil (NOT static)
        return jwtUtil.generateToken(
                admin.getAdminEmail(),
                admin.getRole().name()
        );
    }

    // ✅ GET ALL ADMINS
    @Override
    public List<AdminResponseDTO> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(AdminMapper::toDTO)
                .toList();
    }

    // ✅ GET ADMIN BY ID
    @Override
    public AdminResponseDTO getById(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return AdminMapper.toDTO(admin);
    }

    // ✅ DELETE ADMIN
    @Override
    public void delete(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new RuntimeException("Admin not found");
        }
        adminRepository.deleteById(id);
    }

    @Override
    public AdminResponseDTO update(Long id, AdminRegisterDTO dto) {
        return null; // implement later
    }
}
