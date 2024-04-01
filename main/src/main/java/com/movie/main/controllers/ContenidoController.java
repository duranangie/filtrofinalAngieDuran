package com.movie.main.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.main.models.dtos.ContenidoDTO;
import com.movie.main.services.ContenidoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/contenido")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class ContenidoController {
      @Autowired
      ContenidoService contenidoService;

      @PostMapping
      public Map<Object, Object> guardarContenido(@RequestBody ContenidoDTO contenidoDTO) {
            return contenidoService.guardarContenido(contenidoDTO);
      }

      @PutMapping("/{id}")
      public Map<Object, Object> editarContenido(@PathVariable Object id, @RequestBody ContenidoDTO contenidoDTO) {
            return contenidoService.editarContenido(id, contenidoDTO);
      }

      @DeleteMapping("/{id}")
      public Map<Object, Object> eliminarContenido(@PathVariable Object id) {
            return contenidoService.eliminarContenido(id);
      }
}