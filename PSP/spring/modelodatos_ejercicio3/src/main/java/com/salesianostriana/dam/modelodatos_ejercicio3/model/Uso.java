package com.salesianostriana.dam.modelodatos_ejercicio3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:MM")
    private LocalDateTime fechaFin;

    private double coste;

    @ManyToOne
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne
    @ToString.Exclude
    private Bicicleta bicicleta;

    @ManyToOne
    private Estacion estacion;

    private boolean terminado;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Uso uso = (Uso) o;
        return getId() != null && Objects.equals(getId(), uso.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
