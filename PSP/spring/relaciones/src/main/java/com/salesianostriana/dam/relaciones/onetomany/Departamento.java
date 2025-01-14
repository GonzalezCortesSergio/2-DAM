package com.salesianostriana.dam.relaciones.onetomany;

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
public class Departamento {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, direccion;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(
            mappedBy = "departamento",
            fetch = FetchType.EAGER
    )
    private List<Empleado> empleados = new ArrayList<>();

    public void addEmpleado(Empleado empleado) {

        empleado.setDepartamento(this);
        this.empleados.add(empleado);
    }

    public void removeEmpleado(Empleado empleado) {

        this.empleados.remove(empleado);
        empleado.setDepartamento(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Departamento that = (Departamento) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
