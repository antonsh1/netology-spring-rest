package ru.smartjava.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.smartjava.rest.auth.AuthorizationService;
import ru.smartjava.rest.enums.Authorities;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("name") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}