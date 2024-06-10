package com.webservice.project.config;

import com.webservice.project.entities.Order;
import com.webservice.project.entities.User;
import com.webservice.project.repositories.OrderRepository;
import com.webservice.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Cristian Jonatas", "cristian.jonatas@outlook.com", "(75)99938-2278", "918273");
        User user2 = new User("Rafael Sena", "rafael.senaramos@gmail.com", "(81)99965-7987", "316497");

        Order order1 = new Order(Instant.parse("2018-08-13T08:16:05Z"), user1);
        Order order2 = new Order(Instant.parse("2011-09-04T19:03:03Z"), user2);
        Order order3 = new Order(Instant.parse("2011-09-06T18:27:34Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
