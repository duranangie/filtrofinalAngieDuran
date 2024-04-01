package com.movie.main.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.main.models.TipoContenido;
import com.movie.main.services.TipoContenidoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("tipocontenido")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class TipoContenidoController {
    @Autowired
    TipoContenidoService tipoContenidoService;

    @PostMapping
    public Map<Object, Object> guardarTipoContenido(@RequestBody TipoContenido tipoContenido) {
        return tipoContenidoService.guardarTipoContenido(tipoContenido);
    }

    @PostMapping("/agregarPlataforma")
    public Map<Object, Object> agregarPlataforma(@RequestBody Map<Object, Object> valores) {
        return tipoContenidoService.agregarPlataforma(valores);
    }
}