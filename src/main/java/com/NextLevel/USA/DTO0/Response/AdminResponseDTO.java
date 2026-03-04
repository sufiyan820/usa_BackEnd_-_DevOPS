package com.NextLevel.USA.DTO0.Response;

import com.NextLevel.USA.Enum.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AdminResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
