package com.example.BlogApp.Service;

import com.example.BlogApp.dto.LoginUserDTO;
import com.example.BlogApp.dto.UserDTO;
import com.example.BlogApp.model.Users;
import com.example.BlogApp.repo.UserRepo;
import com.example.BlogApp.security.serviceSec.JwtService;
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


}
