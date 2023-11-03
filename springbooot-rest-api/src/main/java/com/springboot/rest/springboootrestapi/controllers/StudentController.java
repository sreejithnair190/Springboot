package com.springboot.rest.springboootrestapi.controllers;

import com.springboot.rest.springboootrestapi.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public ResponseEntity<Student> getStudent(){

        Student student = new Student(1, "Sreejith", "Nair");
//        return new ResponseEntity<>(student, HttpStatus.OK);

        return ResponseEntity.ok().header("custom header", "nemo").body(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){

        Student student = new Student(id, "Sreejith", "Nair");
        return ResponseEntity.ok(student);
    }
}
