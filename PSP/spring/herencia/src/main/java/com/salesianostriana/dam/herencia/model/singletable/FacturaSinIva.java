package com.salesianostriana.dam.herencia.model.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@DiscriminatorValue("sinIva")
public class FacturaSinIva extends Factura{
}
