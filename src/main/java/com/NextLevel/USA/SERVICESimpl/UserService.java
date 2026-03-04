package com.NextLevel.USA.SERVICESimpl;

import com.NextLevel.USA.DTO0.request.o.User.UserRegisterDTO;
import com.NextLevel.USA.DTO0.Response.UserResponseDTO;
import com.NextLevel.USA.DTO0.request.o.User.UserUpdateDTO;
import com.NextLevel.USA.ENTITIES.User;
import com.NextLevel.USA.Enum.Role;
import com.NextLevel.USA.Util.JwtUtil;
import com.NextLevel.USA.jpAREPOSITORIES.UserRepo;
import com.NextLevel.USA.Services.UserInterService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService implements UserInterService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil  jwtUtil;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ===== Register from DTO =====
    @Override
    public User register(UserRegisterDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER); // Always USER role
        return userRepo.save(user);
    }

    // ===== Optional: Register from User entity =====
    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepo.save(user);
    }

    // ===== Find user by email =====
    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public User userUpdate(Long id, UserUpdateDTO dto) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SORRY \n User Not Found"));
        if(dto.getName() != null && !dto.getEmail().isEmpty()){
            existingUser.setName(dto.getName());
        }

        if(dto.getEmail() != null && !dto.getEmail().isEmpty()) {
                existingUser.setEmail(dto.getEmail());
        }

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()){
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return userRepo.save(existingUser);
    }


    @Override
    public User updatePassword(Long id, UserUpdateDTO dto) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Oops: \n User Not Found"));
        if(dto.getPassword() != null && !dto.getPassword().isEmpty()){
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            existingUser.setEmail(dto.getEmail());
        }


        return userRepo.save(existingUser);
    }

    // ===== Login =====
    @Override
    public User login(User user) {
        User found = userRepo.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("Opps : \n User Not Found"));

        if (!passwordEncoder.matches(user.getPassword(), found.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return found;
    }

    // ===== Convert User to UserResponseDTO =====
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public String login(String email, String password) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );
    }
}
