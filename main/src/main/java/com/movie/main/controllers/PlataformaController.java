package com.movie.main.controllers;

import java.util.Map;

import com.movie.main.models.Plataforma;
import com.movie.main.services.PlataformaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plataforma")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class PlataformaController {
    @Autowired
    PlataformaService plataformaService;

    @PostMapping
    public Map<Object, Object> guardarPlataforma(
            @RequestBody Plataforma plataforma) {
        return plataformaService.guardarPlataforma(plataforma);
    }

    @PostMapping("/agregarContenido")
    public Map<Object, Object> agregarTipoContenido(
            @RequestBody Map<Object, Object> valores) {
        return plataformaService.agregarTipoContenido(valores);
    }

}