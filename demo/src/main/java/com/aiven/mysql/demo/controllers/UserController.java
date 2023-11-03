package com.aiven.mysql.demo.controllers;

import com.aiven.mysql.demo.entities.User;
import com.aiven.mysql.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
//import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User request){
        try{
            User user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());

            userRepository.save(user);

            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

}
