package com.example.workshop.dto;

import com.example.workshop.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
public class UserDTO implements Serializable {

    private String name;
    private String email;

    public UserDTO(User object){
        name = object.getName();
        email = object.getEmail();
    }
}
