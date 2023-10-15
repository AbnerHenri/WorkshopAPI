package com.example.workshop.services;

import com.example.workshop.dto.UserDTO;
import com.example.workshop.models.User;
import com.example.workshop.repositories.UserRepository;
import com.example.workshop.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public UserDTO findById(String id) {
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            return user.map(UserDTO::new).get();
        }

        return null;
    }
}
