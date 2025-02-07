package com.example.BlogApp.controllers;


import com.example.BlogApp.Service.UserService;
import com.example.BlogApp.dto.UserDTO;
import com.example.BlogApp.model.Article;
import com.example.BlogApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class UserController {

    @Autowired
    UserService service;  //12

    @GetMapping
    public ResponseEntity<String> helloMess() {
        return new ResponseEntity<>(service.printHelloMess(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<List<User>>(service.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO user = service.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.createUser(user);
        return null;
    }

}
