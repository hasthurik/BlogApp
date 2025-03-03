package com.example.BlogApp.controllers;


import com.example.BlogApp.Service.UserService;
import com.example.BlogApp.dto.LoginUserDTO;
import com.example.BlogApp.dto.UserDTO;
import com.example.BlogApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    //регистрация нового пользователя
    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users users) {
        return new ResponseEntity<>(service.register(users), HttpStatus.OK);
    }

    //авторизация
    @PostMapping("/login")
    public String login(@RequestBody LoginUserDTO user) {
        return service.verify(user);
    }

    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        return null;
    }

    //Получение всех пользователей (dto)
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }

    //пользователь по id (dto)
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO user = service.getById(id);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Регистрация нового пользователя
    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    //обновление данных пользователя
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Integer id) {
        return new ResponseEntity<>(service.updateUserData(user, id), HttpStatus.OK);
    }
}
