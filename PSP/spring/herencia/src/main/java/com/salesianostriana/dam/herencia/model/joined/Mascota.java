package com.salesianostriana.dam.herencia.model.joined;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Mascota extends Animal{

    private String nombre;
    private String duenio;
}
