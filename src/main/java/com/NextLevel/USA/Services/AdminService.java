package com.NextLevel.USA.Services;

import com.NextLevel.USA.DTO0.Response.AdminResponseDTO;
import com.NextLevel.USA.DTO0.request.o.AdminRegisterDTO;
import com.NextLevel.USA.ENTITIES.Admin;

import java.util.List;
public interface AdminService {

    AdminResponseDTO register(AdminRegisterDTO dto);

    List<AdminResponseDTO> getAllAdmins();

    AdminResponseDTO getById(Long id);

    AdminResponseDTO update(Long id, AdminRegisterDTO dto);

    void delete(Long id);


    String login(String email, String password);
}
