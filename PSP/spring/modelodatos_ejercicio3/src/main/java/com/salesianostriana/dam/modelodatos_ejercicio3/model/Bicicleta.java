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
public class Bicicleta {

    @Id
    @GeneratedValue
    private Long id;

    private String marca, modelo, estado;

    @ManyToOne
    @ToString.Exclude
    private Estacion estacion;

    @OneToMany(
            mappedBy = "bicicleta",
            fetch = FetchType.EAGER
    )
    @Builder.Default
    @ToString.Exclude
    private List<Uso> listaUsos = new ArrayList<>();


    public void addUso(Uso uso) {

        uso.setBicicleta(this);
        this.listaUsos.add(uso);
    }

    public void removeUso(Uso uso) {

        this.listaUsos.remove(uso);
        uso.setBicicleta(null);
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Bicicleta bicicleta = (Bicicleta) o;
        return getId() != null && Objects.equals(getId(), bicicleta.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
