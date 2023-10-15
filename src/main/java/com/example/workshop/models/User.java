package com.example.workshop.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "users")
public class User {


    private String id;

    private String name;
    private String email;
}
