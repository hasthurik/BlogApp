package com.example.BlogApp.security;

import com.example.BlogApp.model.Role;
import com.example.BlogApp.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void run(String... args) {
        if (roleRepo.findByName("ROLE_USER").isEmpty())
            roleRepo.save(new Role("ROLE_USER"));
        if (roleRepo.findByName("ROLE_ADMIN").isEmpty())
            roleRepo.save(new Role("ROLE_ADMIN"));
    }
}
