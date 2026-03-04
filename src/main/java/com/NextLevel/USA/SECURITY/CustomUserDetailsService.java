package com.NextLevel.USA.SECURITY;

import com.NextLevel.USA.ENTITIES.Admin;
import com.NextLevel.USA.ENTITIES.User;
import com.NextLevel.USA.jpAREPOSITORIES.AdminRepository;
import com.NextLevel.USA.jpAREPOSITORIES.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final UserRepo userRepo;

    public CustomUserDetailsService(AdminRepository adminRepository, UserRepo userRepo) {
        this.adminRepository = adminRepository;
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // 1️⃣ Try Admin first
        if (adminRepository.findByAdminEmail(email).isPresent()) {
            Admin admin = adminRepository.findByAdminEmail(email).get();
            return new org.springframework.security.core.userdetails.User(
                    admin.getAdminEmail(),
                    admin.getPassword(),
                    Collections.singletonList(
                            new SimpleGrantedAuthority("ROLE_" + admin.getRole().name())
                    )
            );
        }

        // 2️⃣ Try User
        if (userRepo.findByEmail(email).isPresent()) {
            User user = userRepo.findByEmail(email).get();
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singletonList(
                            new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
                    )
            );
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
