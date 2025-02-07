package com.example.BlogApp.Service;

import com.example.BlogApp.dto.UserDTO;
import com.example.BlogApp.model.User;
import com.example.BlogApp.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public String printHelloMess() {
        return "hello mes";
    }


    public List<User> getAllUser() {
        return repo.findAll();
    }


    public UserDTO getById(int id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return modelMapper.map(user, UserDTO.class);

    }

    public void createUser(User user) {
        repo.save(user);
    }
}
