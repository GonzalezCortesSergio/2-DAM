package com.salesianostriana.dam.modelodatos_ejercicio3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Uso {

    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:MM")
    private LocalDateTime fechaInicio;
}
