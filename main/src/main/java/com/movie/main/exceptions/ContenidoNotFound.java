package com.movie.main.exceptions;

public class ContenidoNotFound extends RuntimeException {
    public ContenidoNotFound(String message) {
        super(message);
    }
}