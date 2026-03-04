package com.NextLevel.USA.Services;

import com.NextLevel.USA.DTO0.request.o.User.UserRegisterDTO;
import com.NextLevel.USA.DTO0.request.o.User.UserUpdateDTO;
import com.NextLevel.USA.ENTITIES.User;

public interface UserInterService {
    User register(UserRegisterDTO dto);

    User register(User user);

    User findByEmail(String email);
    User userUpdate(Long id, UserUpdateDTO dto);
    User updatePassword(Long id, UserUpdateDTO dto);

    User login(User user);
}
