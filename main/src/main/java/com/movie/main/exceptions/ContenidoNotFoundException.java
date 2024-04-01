package com.movie.main.exceptions;

public class ContenidoNotFoundException extends RuntimeException {
    public ContenidoNotFoundException(String message) {
        super(message);
    }
}