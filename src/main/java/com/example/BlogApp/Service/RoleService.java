package com.example.BlogApp.Service;

import com.example.BlogApp.model.Role;
import com.example.BlogApp.model.Users;
import com.example.BlogApp.repo.RoleRepo;
import com.example.BlogApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public void assignRole (String username, String roleName) {
        Users user = userRepo.findByUserName(username).orElseThrow();
        Role role = roleRepo.findByName(roleName).orElseThrow();

        user.getRoles().add(role);
        userRepo.save(user);
    }
}
