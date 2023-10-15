package com.example.workshop.controllers;

import com.example.workshop.dto.UserDTO;
import com.example.workshop.models.User;
import com.example.workshop.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<User> users = service.findAll();
        List<UserDTO> usersDTO = users.stream().map(UserDTO::new).toList();
        return ResponseEntity.status(200).body(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") String id){
        UserDTO user = service.findById(id);
        return user != null ?
                ResponseEntity.status(200).body(user) :
                ResponseEntity.status(400).build();
    }
}
