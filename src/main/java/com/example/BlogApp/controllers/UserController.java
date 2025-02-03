package com.example.BlogApp.controllers;


import com.example.BlogApp.Service.UserService;
import com.example.BlogApp.model.Article;
import com.example.BlogApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
