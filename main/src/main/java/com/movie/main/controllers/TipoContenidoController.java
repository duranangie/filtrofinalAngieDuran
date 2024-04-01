package com.movie.main.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.main.models.TipoContenido;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("tipocontenido")
@CrossOrigin("*")public class TipoContenidoController {    
    @Autowired    
    TipoContenidoService tipoContenidoService;
    @PostMapping()    
    public Map<Object, Object> guardarTipoContenido(@RequestBody TipoContenido tipoContenido) {        
        return tipoContenidoService.guardarTipoContenido(tipoContenido);    
    }
    @PostMapping("/agregarPlataforma")    
    public Map<Object, Object> agregarPlataforma(@RequestBody Map<Object, Object> valores) {        
        return tipoContenidoService.agregarPlataforma(valores);    
    }}