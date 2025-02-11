package com.example.BlogApp.Service;

import com.example.BlogApp.dto.UserDTO;
import com.example.BlogApp.model.User;
import com.example.BlogApp.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<User> users = repo.findAll();
        List<UserDTO> resultUser = new ArrayList<>();
        for (User item : users) {
            resultUser.add(modelMapper.map(item, UserDTO.class));
        }
        return resultUser;
    }


    public UserDTO getById(Integer id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Transactional
    public User updateUserData(User user, Integer id) {
        if (repo.findById(id).orElse(null) == null) return null;
        repo.deleteById(id);
        repo.save(user);
        return user;
    }

    public User createUser(User user) {
        return repo.save(user);
    }
}
