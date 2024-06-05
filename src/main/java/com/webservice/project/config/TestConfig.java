package com.webservice.project.config;

import com.webservice.project.entities.User;
import com.webservice.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Cristian Jonatas", "cristian.jonatas@outlook.com", "(75)99938-2278", "918273");
        User user2 = new User("Rafael Sena", "rafael.senaramos@gmail.com", "(81)99965-7987", "316497");

    userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
