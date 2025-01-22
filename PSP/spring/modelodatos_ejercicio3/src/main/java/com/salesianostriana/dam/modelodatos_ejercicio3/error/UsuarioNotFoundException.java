package com.salesianostriana.dam.modelodatos_ejercicio3.error;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
