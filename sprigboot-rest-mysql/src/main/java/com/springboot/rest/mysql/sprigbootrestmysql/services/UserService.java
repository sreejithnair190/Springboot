package com.springboot.rest.mysql.sprigbootrestmysql.services;

import com.springboot.rest.mysql.sprigbootrestmysql.dto.UserDto;
import com.springboot.rest.mysql.sprigbootrestmysql.entities.User;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public List<User> getUsers();

    public User updateUser(User user);

    public User getAUser(Long id);

    public void deleteAUser(Long id);

}
