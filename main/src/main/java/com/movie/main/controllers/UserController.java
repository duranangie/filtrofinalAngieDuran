package com.movie.main.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.main.models.User;
import com.movie.main.security.JWTAuthenticationConfig;
import com.movie.main.services.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    @Autowired
    JWTAuthenticationConfig jwtAuthenticationConfig;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public User login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {

        userService.userValidation(username, encryptedPass);
        String token = jwtAuthenticationConfig.getJWTToken(username);

        return new User(username, encryptedPass, token);
    }

    @PostMapping("/register")
    public Map<Object, Object> registerUser(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {

        return userService.registerUser(new User(username, encryptedPass, null));
    }
}