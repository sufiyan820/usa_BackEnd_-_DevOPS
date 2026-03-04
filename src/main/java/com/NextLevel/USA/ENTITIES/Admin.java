package com.NextLevel.USA.ENTITIES;

import com.NextLevel.USA.Enum.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "uadmin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_name", nullable = false, length = 100)
    private String adminName;

    @Column(name = "admin_email", nullable = false, unique = true, length = 150)
    private String adminEmail;

    @Column(nullable = false)
    private String password;

    // Store enum as string in DB
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Admin() {}

    public Admin(Long id, String adminName, String adminEmail, String password, Role role) {
        this.id = id;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
