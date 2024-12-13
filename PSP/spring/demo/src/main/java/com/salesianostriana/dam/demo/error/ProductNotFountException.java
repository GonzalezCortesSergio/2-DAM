package com.salesianostriana.dam.demo.error;

public class ProductNotFountException extends RuntimeException {
    public ProductNotFountException(String message) {
        super(message);
    }

    public ProductNotFountException(Long id) {
      super("No hay producto con ese ID: %d".formatted(id));
    }

    public ProductNotFountException() {

      super("No hay productos con esas características");
    }
}
