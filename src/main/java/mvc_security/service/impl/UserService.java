package mvc_security.service.impl;

import java.util.List;

import mvc_security.dto.UserDto;
import mvc_security.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
    
    void deleteUserById(Long userId);
    
}
