package com.example.plataforma.services;

import com.example.plataforma.DTOs.AlunoDTO;
import com.example.plataforma.entities.Aluno;
import com.example.plataforma.entities.Curso;
import com.example.plataforma.repositories.AlunoRepository;
import com.example.plataforma.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AlunoServices {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoServices(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String criarAluno(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        alunoRepository.save(aluno);

        return "Aluno criado com sucesso!";
    }

    public List<AlunoDTO> mostrarAluno() {
        return alunoRepository.findAll().stream()
                .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail()))
                .toList();
    }

    public AlunoDTO buscarAlunoId(long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        return dto;
    }

    public String alterar(long id, AlunoDTO dto) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        alunoRepository.save(aluno);
        return "Aluno alterado com sucesso!";
    }

    public String delete(long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        alunoRepository.deleteById(id);
        return "Aluno excluído com sucesso!";
    }

    public String matricular(long alunoId, long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getMatricula().add(curso);
        alunoRepository.save(aluno);
        return "Aluno matriculado com sucesso!";
    }
}
