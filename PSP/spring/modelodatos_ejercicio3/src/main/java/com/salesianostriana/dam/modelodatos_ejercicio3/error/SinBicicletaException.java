package com.salesianostriana.dam.modelodatos_ejercicio3.error;

public class SinBicicletaException extends RuntimeException {
    public SinBicicletaException() {

        super("No tienes que devolver ninguna bicicleta");
    }
}
