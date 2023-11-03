package com.springboot.rest.mysql.sprigbootrestmysql.services.Impl;

import com.springboot.rest.mysql.sprigbootrestmysql.dto.UserDto;
import com.springboot.rest.mysql.sprigbootrestmysql.entities.User;
import com.springboot.rest.mysql.sprigbootrestmysql.mappers.UserMapper;
import com.springboot.rest.mysql.sprigbootrestmysql.repositories.UserRepository;
import com.springboot.rest.mysql.sprigbootrestmysql.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.userToUserDto(savedUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());

        return userRepository.save(existingUser);
    }

    @Override
    public User getAUser(Long id) {
        Optional<User> user =  userRepository.findById(id);
        return user.get();
    }

    @Override
    public void deleteAUser(Long id) {
        userRepository.deleteById(id);
    }

}
