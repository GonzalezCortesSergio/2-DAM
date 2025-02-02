package com.salesianostriana.dam.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 512)
    private String nombreProducto;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio")
    private double precioVenta;

    @ManyToOne
    @JoinColumn(name = "categoria_id",
            foreignKey = @ForeignKey(name = "fk_producto_categoria"))
    private Categoria categoria;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "producto_tag",
    joinColumns = @JoinColumn (name = "product_id", foreignKey = @ForeignKey(name = "fk_producto_tag")),
    inverseJoinColumns = @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "fk_tag_producto")))
    @Builder.Default
    @Setter(AccessLevel.NONE)
    private Set<Tag> tags = new HashSet<>();

    //HELPER Producto - Tag

    public void addTag(Tag tag) {

        this.tags.add(tag);
        tag.getProductos().add(this);
    }

    public void removeTag(Tag tag) {

        tag.getProductos().remove(this);
        this.tags.remove(tag);
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
