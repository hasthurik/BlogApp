package com.example.BlogApp.Service;


import com.example.BlogApp.model.User;
import com.example.BlogApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public String printHelloMess() {
        return "hello mes";
    }


    public List<User> getAllUser() {
        return repo.findAll();
    }
}
