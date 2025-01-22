package com.salesianostriana.dam.modelodatos_ejercicio3.error;

public class EstacionLlenaException extends RuntimeException {
    public EstacionLlenaException() {

        super("No caben más bicicletas en la estación");
    }
}
