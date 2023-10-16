package com.example.workshop.models;

import com.example.workshop.dto.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}
