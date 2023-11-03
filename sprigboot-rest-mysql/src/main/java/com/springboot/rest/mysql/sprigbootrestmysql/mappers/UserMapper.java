package com.springboot.rest.mysql.sprigbootrestmysql.mappers;

import com.springboot.rest.mysql.sprigbootrestmysql.dto.UserDto;
import com.springboot.rest.mysql.sprigbootrestmysql.entities.User;

public class UserMapper {
    public static UserDto userToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
