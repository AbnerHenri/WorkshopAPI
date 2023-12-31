package com.example.workshop;

import com.example.workshop.dto.AuthorDTO;
import com.example.workshop.models.Post;
import com.example.workshop.models.User;
import com.example.workshop.repositories.PostRepository;
import com.example.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        Post post3 = new Post(null, sdf.parse("25/03/2018"), "Bom Tarde", "Curtindo o fim de semana!", new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

        alex.getPosts().add(post3);
        userRepository.save(alex);
    }
}
