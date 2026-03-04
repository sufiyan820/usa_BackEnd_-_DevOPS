package com.NextLevel.USA.DTO0.request.o.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;


}
