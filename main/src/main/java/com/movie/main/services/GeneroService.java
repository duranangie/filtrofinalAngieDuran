package com.movie.main.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.main.exceptions.GeneroDuplicateException;
import com.movie.main.models.Genero;
import com.movie.main.repositories.GeneroRepository;

@Service 
public class GeneroService {    
    @Autowired    
    GeneroRepository generoRepository;
    public Map<Object, Object> guardarGenero(Genero genero) {     
        try {            
            generoRepository.save(genero);            
            return new LinkedHashMap<>() {{                
                put("message", "El genero ha sido registrado.");            
            }};        } catch (Exception e) {            
                throw new GeneroDuplicateException("El genero ingresado ya existe.");        
            }    
        }}