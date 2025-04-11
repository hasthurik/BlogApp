package com.example.BlogApp.security.serviceSec;

import com.example.BlogApp.model.Users;
import com.example.BlogApp.repo.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUsersDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUsersDetailService(UserRepo repository) {
        this.userRepo = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(
                user.getUsername(),
                user.getPassword(),
                authorities);
    }
}

//@Service
//public class CustomUsersDetailService implements UserDetailsService {
//
//    private final UserRepo repository;
//
//    public CustomUsersDetailService(UserRepo repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return (UserDetails) repository
//                .findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//}