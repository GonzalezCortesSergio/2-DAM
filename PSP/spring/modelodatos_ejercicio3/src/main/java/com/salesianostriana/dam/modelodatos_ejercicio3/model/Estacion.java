package com.salesianostriana.dam.modelodatos_ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    private String numero;

    private String nombre;

    private String coordenadas;

    private int capacidad;

    @OneToMany(mappedBy = "estacion", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Bicicleta> listaBicicletas = new ArrayList<>();

    //HELPER

    public void addBicicleta(Bicicleta bicicleta) throws Exception{

        if(listaBicicletas.size() > capacidad)
            throw new Exception();
        bicicleta.setEstacion(this);
        this.listaBicicletas.add(bicicleta);
    }

    public void removeBicicleta(Bicicleta bicicleta) {

        this.listaBicicletas.remove(bicicleta);
        bicicleta.setEstacion(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estacion estacion = (Estacion) o;
        return getId() != null && Objects.equals(getId(), estacion.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
