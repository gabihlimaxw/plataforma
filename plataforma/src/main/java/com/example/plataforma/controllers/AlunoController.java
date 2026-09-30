package com.example.plataforma.controllers;

import com.example.plataforma.DTOs.AlunoDTO;
import com.example.plataforma.services.AlunoServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    private final AlunoServices service;
    public AlunoController(AlunoServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarAluno(@Valid @RequestBody AlunoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarAluno(dto));
    }

    @GetMapping
    public ResponseEntity<?> mostrarAluno() {
        return ResponseEntity.ok().body(service.mostrarAluno());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAluno(@PathVariable long id) {
        return ResponseEntity.ok().body(service.buscarAlunoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarAluno(@PathVariable long id, @Valid @RequestBody AlunoDTO dto) {
        return ResponseEntity.ok().body(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }

    @PostMapping("/{alunoId}/{cursoId}")
    public ResponseEntity<?> matricular(@PathVariable long alunoId, @PathVariable long cursoId) {
        return ResponseEntity.ok().body(service.matricular(alunoId, cursoId));
    }}