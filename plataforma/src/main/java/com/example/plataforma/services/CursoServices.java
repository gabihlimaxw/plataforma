package com.example.plataforma.services;

import com.example.plataforma.DTOs.CursoDTO;
import com.example.plataforma.entities.Curso;
import com.example.plataforma.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServices {

    private final CursoRepository cursoRepository;
    public CursoServices(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String criarCurso(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso criado com sucesso!";
    }

    public List<CursoDTO> mostrarCurso() {
        return cursoRepository.findAll().stream()
                .map(curso -> new CursoDTO(curso.getId(), curso.getNome(), curso.getCargaHoraria()))
                .toList();
    }

    public CursoDTO buscarCursoId(long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        CursoDTO dto = new CursoDTO();
        dto.setNome(curso.getNome());
        dto.setCargaHoraria(curso.getCargaHoraria());
        return dto;
    }

    public String alterar(long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso alterado com sucesso!";
    }

    public String delete(long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(id);
        return "Curso excluído com sucesso!";
    }
}