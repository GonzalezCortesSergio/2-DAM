package com.salesianostriana.dam.ejercicio01_modeladodatos.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double pvp;

    @ManyToOne
    @JoinColumn(
            name = "categoria_id",
            foreignKey = @ForeignKey(name = "fk_producto_categoria")
    )
    private Categoria categoria;

    public void addToCategoria(Categoria categoria) {

        setCategoria(categoria);
        categoria.getProductos().add(this);
    }

    public void removeFromCategoria(Categoria categoria) {

        categoria.getProductos().remove(this);
        setCategoria(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Producto producto = (Producto) o;
        return getId() != null && Objects.equals(getId(), producto.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
