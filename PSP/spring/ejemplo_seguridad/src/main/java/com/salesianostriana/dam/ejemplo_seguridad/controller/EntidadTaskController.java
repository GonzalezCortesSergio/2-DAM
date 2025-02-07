package com.salesianostriana.dam.ejemplo_seguridad.controller;

import com.salesianostriana.dam.ejemplo_seguridad.dto.CreateEntidadTask;
import com.salesianostriana.dam.ejemplo_seguridad.model.EntidadTask;
import com.salesianostriana.dam.ejemplo_seguridad.service.EntidadTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidad-task")
@RequiredArgsConstructor
public class EntidadTaskController {

    private final EntidadTaskService service;


    @GetMapping
    public List<EntidadTask> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntidadTask findById(@PathVariable Long id) {

        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<EntidadTask> save(@RequestBody CreateEntidadTask createEntidadTask) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(createEntidadTask));
    }
}
