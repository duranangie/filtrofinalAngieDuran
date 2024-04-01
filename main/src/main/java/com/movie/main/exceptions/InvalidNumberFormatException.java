package com.movie.main.exceptions;

public class InvalidNumberFormatException extends RuntimeException {
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}