package com.example.workshop.services.interfaces;

import com.example.workshop.dto.UserDTO;
import com.example.workshop.models.User;

import java.util.List;


public interface UserService {

    List<User> findAll();
    UserDTO findById(String id);
}
