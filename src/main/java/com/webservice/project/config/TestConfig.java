package com.webservice.project.config;

import com.webservice.project.entities.Category;
import com.webservice.project.entities.Order;
import com.webservice.project.entities.Product;
import com.webservice.project.entities.User;
import com.webservice.project.repositories.CategoryRepository;
import com.webservice.project.repositories.OrderRepository;
import com.webservice.project.repositories.ProductRepository;
import com.webservice.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

import static com.webservice.project.entities.enums.OrderStatus.PAID;
import static com.webservice.project.entities.enums.OrderStatus.WAITING_PAYMENT;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Cristian Jonatas", "cristian.jonatas@outlook.com", "(75)99938-2278", "918273");
        User user2 = new User("Rafael Sena", "rafael.senaramos@gmail.com", "(81)99965-7987", "316497");

        Order order1 = new Order(Instant.parse("2018-08-13T08:16:05Z"), PAID, user1);
        Order order2 = new Order(Instant.parse("2011-09-04T19:03:03Z"), WAITING_PAYMENT, user2);
        Order order3 = new Order(Instant.parse("2011-09-06T18:27:34Z"), WAITING_PAYMENT, user1);

        Category category1 = new Category("Electronics");
        Category category2 = new Category("Books");
        Category category3 = new Category("Computers");

        Product product1 = new Product("The Lord of the Rings", "Lorem impsum dolor sit amt, consectetur.", 90.5, "");
        Product product2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

    }
}
