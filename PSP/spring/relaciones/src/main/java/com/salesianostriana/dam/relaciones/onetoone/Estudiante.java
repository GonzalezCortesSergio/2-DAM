package com.salesianostriana.dam.relaciones.onetoone;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Estudiante {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, apellidos, curso;
    private int edad;


    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private InformacionAdicional informacion;


    public void addInformacion(InformacionAdicional informacion) {

        setInformacion(informacion);
        informacion.setEstudiante(this);
    }

    public void removeInformacion(InformacionAdicional informacion) {

        setInformacion(null);
        informacion.setEstudiante(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Estudiante that = (Estudiante) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
