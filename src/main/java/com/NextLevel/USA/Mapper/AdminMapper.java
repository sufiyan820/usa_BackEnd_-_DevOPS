package com.NextLevel.USA.Mapper;

import com.NextLevel.USA.DTO0.Response.AdminResponseDTO;
import com.NextLevel.USA.ENTITIES.Admin;

public class AdminMapper {

    public static AdminResponseDTO toDTO(Admin admin) {

        if (admin == null) {
            return null;
        }

        return AdminResponseDTO.builder()
                .id(admin.getId())
                .name(admin.getAdminName())
                .email(admin.getAdminEmail())
                .role(admin.getRole())
                .build();
    }
}
