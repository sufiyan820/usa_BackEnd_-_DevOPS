package com.NextLevel.USA.DTO0.Response;

import com.NextLevel.USA.Enum.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private  Long id;
    private String name;
    private String email;
    private Role role;
}
