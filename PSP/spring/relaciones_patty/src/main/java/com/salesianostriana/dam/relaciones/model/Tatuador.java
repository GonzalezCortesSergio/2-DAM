package com.salesianostriana.dam.relaciones.model;

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
public class Tatuador {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, estilo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tatuador_cliente",
            joinColumns = @JoinColumn(name = "tatuador_id", foreignKey = @ForeignKey(name = "fk_tatuador_cliente")),
            inverseJoinColumns = @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_cliente_tatuador"))
    )
    @Builder.Default
    private Set<Cliente> clientes = new HashSet<>();


    //HELPER

    public void addCliente(Cliente cliente) {

        this.clientes.add(cliente);
        cliente.getTatuadores().add(this);
    }

    public void removeCliente(Cliente cliente) {

        cliente.getTatuadores().remove(this);
        this.clientes.remove(cliente);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Tatuador tatuador = (Tatuador) o;
        return getId() != null && Objects.equals(getId(), tatuador.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
