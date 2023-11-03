package com.springboot.rest.mysql.sprigbootrestmysql.controllers;

import com.springboot.rest.mysql.sprigbootrestmysql.dto.UserDto;
import com.springboot.rest.mysql.sprigbootrestmysql.entities.User;
import com.springboot.rest.mysql.sprigbootrestmysql.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user){
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getAUser(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteAUser(id);
        return ResponseEntity.ok("Delete User");
    }


}
