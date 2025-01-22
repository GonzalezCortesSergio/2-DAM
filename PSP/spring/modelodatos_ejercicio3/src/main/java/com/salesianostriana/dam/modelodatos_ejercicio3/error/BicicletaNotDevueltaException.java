package com.salesianostriana.dam.modelodatos_ejercicio3.error;

public class BicicletaNotDevueltaException extends RuntimeException {
    public BicicletaNotDevueltaException() {

      super("Antes de coger una bicicleta tienes que dejar la que ya has cogido");
    }
}
