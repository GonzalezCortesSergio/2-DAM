package com.salesianostriana.dam.ejemplo_jwt.security.jwt.refresh;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JwtRefreshRepository extends JpaRepository<JwtRefresh, UUID> {

}
