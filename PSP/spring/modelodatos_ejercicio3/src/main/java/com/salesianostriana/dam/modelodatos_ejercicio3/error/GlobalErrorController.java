package com.salesianostriana.dam.modelodatos_ejercicio3.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    //Errores de Bicicleta

    @ExceptionHandler(BicicletaNotFoundException.class)
    public ProblemDetail handleBicicletaNotFoundException(BicicletaNotFoundException exception) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                exception.getMessage());
        detail.setTitle("Bicicleta no encontrada");

        return detail;
    }

    @ExceptionHandler(BicicletaNotDevueltaException.class)
    public ProblemDetail handleBicicletaNotDevueltaException(BicicletaNotDevueltaException exception) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                exception.getMessage());
        detail.setTitle("Bicicleta no devuelta");

        return detail;
    }

    @ExceptionHandler(SinBicicletaException.class)
    public ProblemDetail handleSinBicicletaException(SinBicicletaException exception) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                exception.getMessage());
        detail.setTitle("No tienes bicicleta");

        return detail;
    }

    //Errores de Estacion

    @ExceptionHandler(EstacionNotFoundException.class)
    public ProblemDetail handleEstacionNotFoundException(EstacionNotFoundException exception) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                exception.getMessage());
        detail.setTitle("Estación no encontrada");

        return detail;
    }

    @ExceptionHandler(EstacionLlenaException.class)
    public ProblemDetail handleEstacionLlenaException(EstacionLlenaException exception) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                exception.getMessage());
        detail.setTitle("Sin espacio");

        return detail;
    }

    //Errores de Usuario

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ProblemDetail handleUsuarioNotFoundException(UsuarioNotFoundException exception) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                exception.getMessage());
        detail.setTitle("Usuario no encontrado");

        return detail;
    }
}
