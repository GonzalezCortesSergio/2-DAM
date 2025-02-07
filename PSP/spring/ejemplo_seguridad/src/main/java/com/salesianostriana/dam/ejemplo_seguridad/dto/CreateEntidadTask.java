package com.salesianostriana.dam.ejemplo_seguridad.dto;

import com.salesianostriana.dam.ejemplo_seguridad.model.EntidadTask;

public record CreateEntidadTask(
        String title
) {

    public EntidadTask toEntidadTask() {

        return EntidadTask.builder()
                .title(this.title)
                .build();
    }
}
