package ru.smartjava.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smartjava.rest.auth.AuthorizationService;
import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.user.Person;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Person person) {
        return service.getAuthorities(person);
    }
}