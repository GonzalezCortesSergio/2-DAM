package com.salesianostriana.dam.ejemplo_seguridad.service;

import com.salesianostriana.dam.ejemplo_seguridad.dto.CreateEntidadTask;
import com.salesianostriana.dam.ejemplo_seguridad.model.EntidadTask;
import com.salesianostriana.dam.ejemplo_seguridad.repository.EntidadTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntidadTaskService {

    private final EntidadTaskRepository repository;

    public List<EntidadTask> findAll() {

        return repository.findAll();
    }

    public EntidadTask getById(Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    public EntidadTask save(CreateEntidadTask entidadTaskDto) {

        return repository.save(entidadTaskDto.toEntidadTask());
    }
}
