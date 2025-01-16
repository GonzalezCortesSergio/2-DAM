package com.salesianostriana.dam.composicion.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String cliente;

    @Builder.Default
    @OneToMany(
            mappedBy = "pedido",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LineaPedido> lineasPedido = new ArrayList<>();

    public void addLineaPedido(LineaPedido lineaPedido) {

        lineaPedido.setPedido(this);
        this.lineasPedido.add(lineaPedido);
    }

    public void removeLineaPedido(LineaPedido lineaPedido) {

        this.lineasPedido.remove(lineaPedido);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pedido pedido = (Pedido) o;
        return getId() != null && Objects.equals(getId(), pedido.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
