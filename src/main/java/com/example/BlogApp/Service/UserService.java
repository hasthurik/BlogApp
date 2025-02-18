package com.example.BlogApp.Service;

import com.example.BlogApp.dto.UserDTO;
import com.example.BlogApp.model.Users;
import com.example.BlogApp.repo.UserRepo;
import com.example.BlogApp.security.serviceSec.JWTService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<UserDTO> getAllUser() {
        List<Users> users = repo.findAll();
        List<UserDTO> resultUser = new ArrayList<>();
        for (Users item : users) {
            resultUser.add(modelMapper.map(item, UserDTO.class));
        }
        return resultUser;
    }


    public UserDTO getById(Integer id) {
        Users user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Transactional
    public Users updateUserData(Users user, Integer id) {
        if (repo.findById(id).orElse(null) == null) return null;
        repo.deleteById(id);
        repo.save(user);
        return user;
    }

    public Users createUser(Users user) {
        return repo.save(user);
    }


    public List<Users> allUsers() {
        return repo.findAll();
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }
        return "fail";
    }
}
