package com.salesianostriana.dam.relaciones.manytomany;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
public class Libro {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int numPaginas;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPublicacion;

    @ToString.Exclude
    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro", foreignKey = @ForeignKey(name = "fk_libro_autor")),
            inverseJoinColumns = @JoinColumn(name = "autor", foreignKey = @ForeignKey(name = "fk_autor_libro"))
    )
    private List<Autor> autores = new ArrayList<>();

    public void addAutor(Autor autor) {

        this.autores.add(autor);
        autor.getLibros().add(this);
    }

    public void removeAutor(Autor autor) {

        autor.getLibros().remove(this);
        this.autores.remove(autor);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Libro libro = (Libro) o;
        return getId() != null && Objects.equals(getId(), libro.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
