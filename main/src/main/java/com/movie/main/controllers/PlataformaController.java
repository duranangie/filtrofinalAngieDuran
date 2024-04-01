package com.movie.main.controllers;

import java.util.Map;

import com.movie.main.models.Plataforma;
import com.movie.main.services.PlataformaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plataforma")
public class PlataformaController {    
    @Autowired    
    PlataformaService plataformaService;

    @PostMapping()    
    public Map<Object, Object> guardarPlataforma(@RequestBody final Plataforma plataforma) {       
         return plataformaService.guardarPlataforma(plataforma);    }
    @PostMapping("/agregarContenido")    
    public Map<Object, Object> agregarTipoContenido(@RequestBody Map<Object, Object> valores) {        
        return plataformaService.agregarTipoContenido(valores);    }

}