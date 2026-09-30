package com.example.plataforma.controllers;

import com.example.plataforma.DTOs.CursoDTO;
import com.example.plataforma.services.CursoServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("curso")
public class CursoController {

    private final CursoServices service;

    public CursoController(CursoServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarCurso(@Valid @RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<?> mostrarCurso() {
        return ResponseEntity.ok().body(service.mostrarCurso());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCurso(@PathVariable long id) {
        return ResponseEntity.ok().body(service.buscarCursoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCurso(
            @PathVariable long id,
            @Valid @RequestBody CursoDTO dto) {

        return ResponseEntity.ok().body(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }


}