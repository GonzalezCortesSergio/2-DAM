package com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh;

import com.salesianostriana.dam.ejemplo_jwt.user.model.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtRefresh {

    @Id
    @GeneratedValue
    private UUID id;


    @OneToOne
    @JoinColumn(name = "usuario_id", columnDefinition = "uuid")
    private Usuario usuario;

    @Column(nullable = false)
    private Instant expireAt;

    @Builder.Default
    private Instant createdAt = Instant.now();
}
