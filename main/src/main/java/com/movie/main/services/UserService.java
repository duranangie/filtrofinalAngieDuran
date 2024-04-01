package com.movie.main.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.main.exceptions.InvalidUserException;
import com.movie.main.exceptions.UserDuplicateException;
import com.movie.main.models.User;
import com.movie.main.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void userValidation(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getEncryptedPass().equalsIgnoreCase(password)) {
            throw new InvalidUserException("Las credenciales ingresadas son incorrectas.");
        }
    }

    public Map<Object, Object> registerUser(User user) {
        try {
            userRepository.save(user);
            return new LinkedHashMap<>() {{
                put("message", "El usuario ha sido registrado.");
            }};
        } catch (Exception e) {
            throw new UserDuplicateException("Nombre de usuario ya existe.");
        }
    }
}