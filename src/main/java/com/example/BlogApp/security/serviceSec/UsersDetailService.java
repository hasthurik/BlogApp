package com.example.BlogApp.security.serviceSec;

import com.example.BlogApp.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailService implements UserDetailsService {

    private final UserRepo repository;

    public UsersDetailService(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) repository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
