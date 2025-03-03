package com.salesianostriana.dam.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFountException.class)
    public ProblemDetail handleProductNotFound(ProductNotFountException exception) {

        ProblemDetail result = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                        exception.getMessage());
        result.setTitle("Producto no encontrado");
        result.setType(URI.create("https://triana.salesianos.edu/errors/product-not-found"));

        return result;
    }
}
