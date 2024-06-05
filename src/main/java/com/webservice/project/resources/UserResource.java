package com.webservice.project.resources;

import com.webservice.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //TODO Colocar mascara para email e telefone, e sugestões de complemento para o email.
    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User("Cristian", "cristian.jonatas@outlook.com", "(75)99938-2278", "918273");
        return ResponseEntity.ok().body(user);
    }
}
