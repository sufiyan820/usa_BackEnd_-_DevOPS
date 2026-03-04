package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.ENTITIES.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long>
{

    Optional<Admin> findByAdminEmail(String adminEmail);
    boolean existsByAdminEmail(String email);


}
