package com.salesianostriana.dam.herencia.model.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@DiscriminatorValue(value = "reducida")
public class FacturaReducida extends Factura{


}
