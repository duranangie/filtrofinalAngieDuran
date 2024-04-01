package com.movie.main.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.main.models.Contenido;
import com.movie.main.models.Usuario;
import com.movie.main.security.JWTAuthenticationConfig;
import com.movie.main.services.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class UsuarioController {
    @Autowired
    JWTAuthenticationConfig jwtAuthenticationConfig;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/ingresar")
    public Usuario ingresar(
            @RequestParam("email") String email, @RequestParam("contraseña") String contraseña) {
        usuarioService.validacionUsuario(email, contraseña);
        String token = jwtAuthenticationConfig.getJWTToken(email);
        return new Usuario(email, contraseña, token);
    }

    @PostMapping("/registrar")
    public Map<Object, Object> registrar(@RequestParam("nombre") String nombre, @RequestParam("email") String email,
            @RequestParam("contraseña") String contraseña) {
        return usuarioService.registrarUsuario(new Usuario(nombre, email, contraseña, null));
    }

    @DeleteMapping("/{id}")
    public Map<Object, Object> eliminarUsuario(@PathVariable Object id) {
        return usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/{id}/contenido")
    public List<Contenido> obtenerContenidos(@PathVariable Object id) {
        return usuarioService.obtenerContenidos(id);
    }
}